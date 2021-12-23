<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">

    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Rubik:400,700'>



    <!-- <link rel="stylesheet" href="./style.css"> -->
    <script>
        document.onreadystatechange = function() {
            if (document.readyState !== "complete") {
                document.querySelector(
                    "body").style.visibility = "hidden";
                document.querySelector(
                    "#loader").style.visibility = "visible";
            } else {
                document.querySelector(
                    "#loader").style.display = "none";
                document.querySelector(
                    "body").style.visibility = "visible";
            }
        };

        var myInput = document.getElementById("psw");
        var letter = document.getElementById("letter");
        var capital = document.getElementById("capital");
        var number = document.getElementById("number");
        var length = document.getElementById("length");

        // When the user clicks on the password field, show the message box
        myInput.onfocus = function() {
            document.getElementById("message").style.display = "block";
        }

        // When the user clicks outside of the password field, hide the message box
        myInput.onblur = function() {
            document.getElementById("message").style.display = "none";
        }

        // When the user starts to type something inside the password field
        myInput.onkeyup = function() {
            // Validate lowercase letters
            var lowerCaseLetters = /[a-z]/g;
            if (myInput.value.match(lowerCaseLetters)) {
                letter.classList.remove("invalid");
                letter.classList.add("valid");
            } else {
                letter.classList.remove("valid");
                letter.classList.add("invalid");
            }

            // Validate capital letters
            var upperCaseLetters = /[A-Z]/g;
            if (myInput.value.match(upperCaseLetters)) {
                capital.classList.remove("invalid");
                capital.classList.add("valid");
            } else {
                capital.classList.remove("valid");
                capital.classList.add("invalid");
            }

            // Validate numbers
            var numbers = /[0-9]/g;
            if (myInput.value.match(numbers)) {
                number.classList.remove("invalid");
                number.classList.add("valid");
            } else {
                number.classList.remove("valid");
                number.classList.add("invalid");
            }

            // Validate length
            if (myInput.value.length >= 8) {
                length.classList.remove("invalid");
                length.classList.add("valid");
            } else {
                length.classList.remove("valid");
                length.classList.add("invalid");
            }
        }
    </script>
</head>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        -webkit-font-smoothing: antialiased;
    }
    
    body {
        background-image: url(Course.jpg);
        font-family: 'Rubik', sans-serif;
    }
    
    .login-form {
        background: whitesmoke;
        width: 500px;
        margin: 65px;
        display: -webkit-box;
        display: flex;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        flex-direction: column;
        border-radius: 4px;
        box-shadow: 0 2px 25px rgba(0, 0, 0, 0.2);
    }
    
    .login-form h1 {
        padding: 35px 35px 0 35px;
        font-weight: 300;
    }
    
    .login-form .content {
        padding: 35px;
        text-align: center;
    }
    
    .login-form .input-field {
        padding: 12px 5px;
    }
    
    .login-form .input-field input {
        font-size: 16px;
        display: block;
        font-family: 'Rubik', sans-serif;
        width: 100%;
        padding: 10px 10px;
        border: 4;
        border-bottom: 1px solid yellowgreen;
        outline: none;
        -webkit-transition: all .2s;
        transition: all .2s;
    }
    
    .login-form .input-field input::-webkit-input-placeholder {
        text-transform: uppercase;
    }
    
    .login-form .input-field input::-moz-placeholder {
        text-transform: uppercase;
    }
    
    .login-form .input-field input:-ms-input-placeholder {
        text-transform: uppercase;
    }
    
    .login-form .input-field input::-ms-input-placeholder {
        text-transform: uppercase;
    }
    
    .login-form .input-field input::placeholder {
        text-transform: uppercase;
    }
    
    .login-form .input-field input:focus {
        border-color: #222;
    }
    
    .login-form a.link {
        text-decoration: none;
        color: #747474;
        letter-spacing: 0.2px;
        text-transform: uppercase;
        display: inline-block;
        margin-top: 20px;
    }
    
    .login-form a.link .action {
        display: -webkit-box;
        display: flex;
        -webkit-box-orient: horizontal;
        -webkit-box-direction: normal;
        flex-direction: row;
    }
    
    .login-form .action button {
        width: 100%;
        border: none;
        padding: 18px;
        font-family: 'Rubik', sans-serif;
        cursor: pointer;
        text-transform: uppercase;
        background: #e8e9ec;
        color: #777;
        border-bottom-left-radius: 4px;
        border-bottom-right-radius: 0;
        letter-spacing: 0.2px;
        outline: 0;
        -webkit-transition: all .3s;
        transition: all .3s;
    }
    
    .login-form .action button:hover {
        background: greenyellow;
    }
    
    .login-form .action button:nth-child(2) {
        background: #2d3b55;
        color: #fff;
        border-bottom-left-radius: 0;
        border-bottom-right-radius: 4px;
    }
    
    .login-form .action button:nth-child(2):hover {
        background: #3c4d6d;
    }
    
    #loader {
        border: 12px solid #f3f3f3;
        border-radius: 50%;
        border-top: 12px solid #444444;
        width: 70px;
        height: 70px;
        animation: spin 1s linear infinite;
    }
    
    @keyframes spin {
        100% {
            transform: rotate(360deg);
        }
    }
    
    .center {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        margin: auto;
    }
    
    .footer {
        background-color: blue;
    }
</style>

<body>
    <!-- partial:index.partial.html -->
    <div class="login-form">

        <form>
            <h1>Login</h1>

            <div class="content">
                <div class="input-field">
                    <input type="email" placeholder="Email" autocomplete="nope" required>
                </div>

                <div class="input-field">
                    <input type="password" placeholder="Password" autocomplete="new-password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one
                            uppercase and lowercase letter, and at least 8 or
                            more characters" required>
                </div>

                <a href="#" target="_blank" class="link">Forgot Your
                        Password?</a>
            </div>

            <div class="action">

                <button><a href="Register.html">Register</a></button>
                <button><a href="Signed.jsp">Sign in</a></button>

            </div>

            <div id="loader" class="center"></div>
        </form>
    </div>


    <!-- partial -->
    <!-- <script src="./script.js"></script> -->

    <br><br><br>
    <div class="footer">
        <center>
            <footer> &copy; KGiSL GSS 2021 </footer>
        </center>
    </div>



</body>

</html>