function Submit() {
    alert("adding the Row...");
    const newcourse = {
        Course_id: document.getElementById("Course_id").value,
        Department_Name: document.getElementById("Department_Name").value,
        Start_Date: document.getElementById("Start_Date").value,
        End_Date: document.getElementById("End_Date").value,
        No_Of_Semester: document.getElementById("No_Of_Semester").value

    };
    console.log(newcourse);
    var xhttp = new XMLHttpRequest();
    // xmlhttp.onreadystatechange = function() {
    //     if (this.readyState == 4 && this.status == 200) {
    //         document.getElementById("txtHint").innerHTML = this.responseText;
    //     }
    // }
    xhttp.open("POST", "http://localhost:9090/Course", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(newcourse));
}



function get_Course() {
    alert("Adding the List...");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            _diplayItem(JSON.parse(xhttp.responseText));
            console.log(xhttp.responseText);
        }
    };
    xhttp.open("GET", "http://localhost:9090/Course", true);
    xhttp.send();
}

function _diplayItem(data) {
    const tBody = document.getElementById("courseset");
    tBody.innerHTML = "";

    const button = document.createElement("button");

    data.forEach(item => {

        //CREATE EDIT BUTTON
        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `editItem(${item.course_Id})`);

        //CREATE DELETE BUTTON  
        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `deleteItem(${item.course_Id})`);

        //INSERT THE ROW IN THE TABLE
        let tr = tBody.insertRow();

        //INSERT 1ST COLUMN
        let td1 = tr.insertCell(0);
        let custid = document.createTextNode(item.course_Id);
        td1.appendChild(custid);

        //INSERT 2ST COLUMN
        let td2 = tr.insertCell(1);
        let custname = document.createTextNode(item.department_name);
        td2.appendChild(custname);

        //INSERT 3ST COLUMN
        let td3 = tr.insertCell(2);
        let custname_1 = document.createTextNode(item.start_date);
        td3.appendChild(custname_1);

        //INSERT 4TH COLUMN
        let td4 = tr.insertCell(3);
        let custname_2 = document.createTextNode(item.end_date);
        td4.appendChild(custname_2);

        //INSERT 5TH COLUMN
        let td5 = tr.insertCell(4);
        let custname_3 = document.createTextNode(item.no_of_semester);
        td5.appendChild(custname_3);



        //DISPLAY EDIT BUTTON
        let td6 = tr.insertCell(5);
        td6.appendChild(editButton);

        //DELETE EDIT BUTTON
        let td7 = tr.insertCell(6);
        td7.appendChild(deleteButton);

    });
    courseset = data;

}

// function to add a data in db through the post method in servlet
function add() {
    alert("ADDING TO TABLE...")
    console.log("add")

    // creating a obj with a enity class properties
    const newcourse = {
        course_Id: document.getElementById("Course_id").value,
        department_name: document.getElementById("Department_Name").value,
        start_date: document.getElementById("Start_Date").value,
        end_date: document.getElementById("End_Date").value,
        no_of_semester: document.getElementById("No_Of_Semester").value
    };
    console.log(newcourse);

    //creating xttp var
    var xhttp = new XMLHttpRequest();

    //calling post method
    xhttp.open("POST", "http://localhost:9090/Course", true);

    //definding the type of data is transfered
    xhttp.setRequestHeader("Content-type", "application/json");

    //  getuserdetails();
    xhttp.send(JSON.stringify(newcourse));

}