package io.manishedu.securecapita.repository.Implementation;

import io.manishedu.securecapita.exception.ApiException;
import io.manishedu.securecapita.model.Role;
import io.manishedu.securecapita.model.User;
import io.manishedu.securecapita.payload.EmailService;
import io.manishedu.securecapita.query.UserQuery;
import io.manishedu.securecapita.repository.RoleRepository;
import io.manishedu.securecapita.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import static io.manishedu.securecapita.enumeration.RoleType.ROLE_USER;
import static io.manishedu.securecapita.enumeration.VerificationType.ACCOUNT;
import static io.manishedu.securecapita.query.UserQuery.COUNT_USER_EMAIL_QUERY;
import static io.manishedu.securecapita.query.UserQuery.INSERT_ACCOUNT_VERFICATION_URL_QUERY;
import static java.util.Objects.requireNonNull;
@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {
    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    @Autowired
    private RoleRepositoryImpl roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EmailService emailService;

    @Override
    public User create(User user) {
        //checking if the email is unique or not
        if (getEmailCount(user.getEmail().trim().toLowerCase()) > 0)
            throw new ApiException("Email is already in use. Please use different email and try again");
        // save the user
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(UserQuery.INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());
            String verificationUrl= getVerificationUrl(UUID.randomUUID().toString(),ACCOUNT.getType());
            jdbc.update(INSERT_ACCOUNT_VERFICATION_URL_QUERY,Map.of("userId",user.getId(),"url",verificationUrl));
            emailService.sendVerficationUrl(user.getFirstname(),user.getEmail(),verificationUrl,ACCOUNT.toString());
            user.setEnabled(false);
            user.setNotLocked(true);
            return user;

        } catch (EmptyResultDataAccessException exception) {
            throw new ApiException("NO role found by the name: "+ROLE_USER.name());

        } catch (Exception exception) {
            throw new ApiException("Error occurred. Please try again!!");
        }
    }




    @Override
    public Collection<User> list(int page, int pageSize) {
        return null;
    }

    @Override
    public User get(long Id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public boolean delete(long Id) {
        return false;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user) {
        return new MapSqlParameterSource().addValue("firstname", user.getFirstname())
                .addValue("lastname", user.getLastname())
                .addValue("email", user.getEmail())
                .addValue("password", bCryptPasswordEncoder.encode(user.getPassword()));
    }
    private String getVerificationUrl(String key, String type) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/verify?type="+type +"/key="+key).toUriString();
    }

}
