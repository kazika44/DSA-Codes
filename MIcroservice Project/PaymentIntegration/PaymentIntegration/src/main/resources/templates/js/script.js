async function startPayment() {
    try {
        const amount = document.getElementById("user_amount").textContent;
        document.getElementById("changeAmountLink").addEventListener("click", function(event) {
            event.preventDefault(); // Prevent default behavior of the link

            // Update the amount in the <sup> element
            const newAmount = "$19.99";
            document.getElementById("user_amount").textContent = newAmount;
        });

        // Validate input (optional)
        if (!amount || isNaN(amount)) {
            throw new Error("Invalid amount");
        }

        const baseUrl = "http://localhost:8086";
        const response = await fetch(`${baseUrl}/payment/start`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ 'amount': amount })
        });

        if (!response.ok) {
            throw new Error('Failed to initiate payment');
        }

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error(error);
        alert("Error in initiating payment");
    }
}
