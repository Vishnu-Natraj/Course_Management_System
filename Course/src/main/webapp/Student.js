function get_Student() {
    alert("Student calling... ")
    const newstudent = {
        Student_Id: document.getElementById("Student_Id").value,
        Student_name: document.getElementById("Student_name").value,
        Address_Id: document.getElementById("Address_Id").value,
        Course_Id: document.getElementById("Course_Id").value,
        Age: document.getElementById("Age").value,
        DOB: document.getElementById("DOB").value,
        Fees: document.getElementById("Fees").value,
        Gender: document.getElementById("Gender").value,
        Phone_Number: document.getElementById("Phone_Number").value,
        Mark_1: document.getElementById("Mark_1").value,
        Mark_2: document.getElementById("Mark_2").value,
        Mark_3: document.getElementById("Mark_3").value,
        Email: document.getElementById("Email").value,
        Attendance: document.getElementById("Attendance").value,
        GPA: document.getElementById("GPA").value
    };

    console.log(newstudent);
    var xhttp = new XMLHttpRequest();
    // xmlhttp.onreadystatechange = function() {
    //     if (this.readyState == 4 && this.status == 200) {
    //         document.getElementById("txtHint").innerHTML = this.responseText;
    //     }
    // }
    xhttp.open("POST", "http://localhost:9090/Student", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(newstudent));
}



function get_Student() {
    alert("Adding the List...");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            _diplayItem(JSON.parse(xhttp.responseText));
            console.log(xhttp.responseText);
        }
    };
    xhttp.open("GET", "http://localhost:9090/Student", true);
    xhttp.send();
}

function _diplayItem(data) {
    const tBody = document.getElementById("studentset");
    tBody.innerHTML = "";

    const button = document.createElement("button");

    data.forEach(item => {

        //CREATE EDIT BUTTON
        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `editItem(${item.Student_id})`);

        //CREATE DELETE BUTTON  
        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `deleteItem(${item.Student_Id})`);

        //INSERT THE ROW IN THE TABLE
        let tr = tBody.insertRow();

        //INSERT 1ST COLUMN
        let td1 = tr.insertCell(0);
        let custid = document.createTextNode(item.Student_Id);
        td1.appendChild(custid);


        // //INSERT 2ND COLUMN
        // let td2 = tr.insertCell(1);
        // let custname_0 = document.createTextNode(item.course_Id);
        // td2.appendChild(custname_0);

        //INSERT 3RD COLUMN
        let td2 = tr.insertCell(1);
        let custname_0 = document.createTextNode(item.Student_name);
        td2.appendChild(custname_0);

        //INSERT 4ST COLUMN
        let td3 = tr.insertCell(2);
        let custname_1 = document.createTextNode(item.Address_Id);
        td3.appendChild(custname_1);

        //INSERT 5TH COLUMN
        let td4 = tr.insertCell(3);
        let custname_2 = document.createTextNode(item.Course_Id);
        td4.appendChild(custname_2);

        //INSERT 5TH COLUMN
        let td5 = tr.insertCell(4);
        let custname_3 = document.createTextNode(item.Age);
        td5.appendChild(custname_3);

        //INSERT 6TH COLUMN
        let td6 = tr.insertCell(5);
        let custname_4 = document.createTextNode(item.DOB);
        td6.appendChild(custname_4);

        //INSERT 7TH COLUMN
        let td7 = tr.insertCell(6);
        let custname_5 = document.createTextNode(item.Fees);
        td7.appendChild(custname_5);

        //INSERT 8TH COLUMN
        let td8 = tr.insertCell(7);
        let custname_6 = document.createTextNode(item.Gender);
        td8.appendChild(custname_6);

        //INSERT 9TH COLUMN
        let td9 = tr.insertCell(8);
        let custname_7 = document.createTextNode(item.Phone_Number);
        td9.appendChild(custname_7);

        //INSERT 10TH COLUMN
        let td10 = tr.insertCell(9);
        let custname_8 = document.createTextNode(item.Mark_1);
        td10.appendChild(custname_8);

        //INSERT 11TH COLUMN
        let td11 = tr.insertCell(10);
        let custname_9 = document.createTextNode(item.Mark_2);
        td11.appendChild(custname_9);

        //INSERT 12TH COLUMN
        let td12 = tr.insertCell(11);
        let custname_10 = document.createTextNode(item.Mark_3);
        td12.appendChild(custname_10);

        //INSERT 13TH COLUMN
        let td13 = tr.insertCell(12);
        let custname_11 = document.createTextNode(item.Email);
        td13.appendChild(custname_11);

        //INSERT 14TH COLUMN
        let td14 = tr.insertCell(13);
        let custname_12 = document.createTextNode(item.Attendance);
        td14.appendChild(custname_12);

        //INSERT 15TH COLUMN
        let td15 = tr.insertCell(14);
        let custname_13 = document.createTextNode(item.GPA);
        td15.appendChild(custname_13);



        //DISPLAY EDIT BUTTON
        let td16 = tr.insertCell(15);
        td16.appendChild(editButton);

        //DELETE EDIT BUTTON
        let td17 = tr.insertCell(16);
        td17.appendChild(deleteButton);

    });
    studentset = data;

}

// function to add a data in db through the post method in servlet
function AddMe() {
    alert("ADDING STUDENT TO TABLE vishnu...")
    console.log("AddMe")

    //creating a obj with a enity class properties

    const newstudent = {
        Student_Id: document.getElementById("Student_Id").value,
        Student_name: document.getElementById("Student_name").value,
        Address_Id: document.getElementById("Address_Id").value,
        Course_Id: document.getElementById("Course_Id").value,
        Age: document.getElementById("Age").value,
        DOB: document.getElementById("DOB").value,
        Fees: document.getElementById("Fees").value,
        Gender: document.getElementById("Gender").value,
        Phone_Number: document.getElementById("Phone_Number").value,
        Mark_1: document.getElementById("Mark_1").value,
        Mark_2: document.getElementById("Mark_2").value,
        Mark_3: document.getElementById("Mark_3").value,
        Email: document.getElementById("Email").value,
        Attendance: document.getElementById("Attendance").value,
        GPA: document.getElementById("GPA").value
    };
    console.log(newstudent);

    //creating xttp var
    var xhttp = new XMLHttpRequest();

    //calling post method
    xhttp.open("POST", "http://localhost:9090/Student", true);

    //definding the type of data is transfered
    xhttp.setRequestHeader("Content-type", "application/json");

    //  getuserdetails();
    xhttp.send(JSON.stringify(newstudent));

}