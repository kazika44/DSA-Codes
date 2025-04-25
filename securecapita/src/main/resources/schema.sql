#################################################################
###                                                          ####
### Author: Manish Kumar                                     ####
### License: manishedu                                       ####
### Date: April 28th, 2024                                   ####
### Version: 1.0                                             ####
###                                                          ####
#################################################################

CREATE SCHEMA IF NOT EXISTS securecapita;

SET NAMES 'UTF8MB4';
SET TIME_ZONE = '-4:00';


USE securecapita;

DROP TABLE IF EXISTS Users;
CREATE TABLE Users
(
    id           BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name   varchar(50)     not null,
    last_name    varchar(50)     not null,
    email        varchar(100)    not null,
    password     varchar(255) default null,
    address      varchar(255) default null,
    phone        varchar(30)  default null,
    title        varchar(50)  default null,
    bio          varchar(255) default null,
    enabled      BOOLEAN      DEFAULT FALSE,
    non_locked   BOOLEAN      DEFAULT TRUE,
    using_mfa    BOOLEAN      DEFAULT FALSE,
    created_date DATETIME     DEFAULT CURRENT_TIMESTAMP,
    image_url    varchar(255) DEFAULT 'https://www.flaticon.com/free-icon/user_149071?term=user&related_id=149071F',
    CONSTRAINT UQ_Users_Email UNIQUE (email)
);

DROP TABLE IF EXISTS Roles;

CREATE TABLE Roles
(
    id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name       varchar(50)     not null,
    permission varchar(255)    not null,
    CONSTRAINT UQ_Roles_Name UNIQUE (name)


);
DROP TABLE IF EXISTS UserRoles;
CREATE TABLE UserRoles
(
    id      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    role_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES Roles (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT UQ_UserRoles_User_Id UNIQUE (user_id)
);

DROP TABLE IF EXISTS Events;
CREATE TABLE Events
(
    id          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type        varchar(50)     not null CHECK ( type in
                                                 ('LOGIN_ATTEMPT', 'LOGIN_ATTEMPT_FAILURE', 'LOGIN_ATTEMPT_SUCCESS',
                                                  'PROFILE_UPDATE', 'PROFILE_PICTURE_UPDATE', 'ROLE_UPDATE',
                                                  'ACCOUNT_SETTING_UPDATE', 'PASSWORD_UPDATE', 'MFA_UPDATE')),
    description varchar(255)    not null,
    CONSTRAINT UQ_Events_Type UNIQUE (type)
);

DROP TABLE IF EXISTS UserEvents;
CREATE TABLE UserEvents
(
    id         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT UNSIGNED NOT NULL,
    event_id   BIGINT UNSIGNED NOT NULL,
    device     varchar(100) default null,
    ip_address varchar(100) default null,
    created_at DATETIME     default CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (event_id) REFERENCES Events (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS AccountVerifications;
CREATE TABLE AccountVerifications
(
    id      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    url     varchar(255) DEFAULT '' NOT NULL,
    -- date DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_AccountVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_AccountVerifications_Url UNIQUE (url)
);

DROP TABLE IF EXISTS ResetPasswordVerifications;
CREATE TABLE ResetPasswordVerifications
(
    id              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT UNSIGNED NOT NULL,
    url             VARCHAR(255)             DEFAULT '' NOT NULL,
    expiration_date DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Corrected DEFAULT clause
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_ResetPasswordVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_ResetPasswordVerifications_Url UNIQUE (url)
);

DROP TABLE IF EXISTS TwoFactorVerifications;
CREATE TABLE TwoFactorVerifications
(
    id              BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT UNSIGNED NOT NULL,
    code            VARCHAR(10)              DEFAULT '' NOT NULL,
    expiration_date DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Corrected DEFAULT clause
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_TwoFactorVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_TwoFactorVerifications_Code UNIQUE (code)
);
















