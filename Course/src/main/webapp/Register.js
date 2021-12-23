function Register() {
    alert("Registered...")
    console.log("Register")

    // creating a obj with a enity class properties
    const newregister = {
        Username: document.getElementById("Username").value,
        Email_Address: document.getElementById("Email_Address").value,
        Password: document.getElementById("Password").value,
        Confirm_Password: document.getElementById("Confirm_Password").value
    };
    console.log(newregister);

    //creating xttp var
    var xhttp = new XMLHttpRequest();

    //calling post method
    xhttp.open("POST", "http://localhost:9090/Register", true);

    //definding the type of data is transfered
    xhttp.setRequestHeader("Content-type", "application/json");

    //  getuserdetails();
    xhttp.send(JSON.stringify(newregister));

}