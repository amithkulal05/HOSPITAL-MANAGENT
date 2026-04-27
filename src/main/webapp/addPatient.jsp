<form action="addPatient" method="post">

Patient ID:
<input type="number" name="id" required><br><br>

Patient Name:
<input type="text" name="name" required><br><br>

Age:
<input type="number" name="age" required><br><br>

Gender:
<select name="gender" required>
    <option value="">Select</option>
    <option value="Male">Male</option>
    <option value="Female">Female</option>
    <option value="Other">Other</option>
</select><br><br>

Admission Date:
<input type="date" name="date" required><br><br>

Ailment:
<input type="text" name="ailment" required><br><br>

Assigned Doctor:
<input type="text" name="doctor" required><br><br>

<input type="submit" value="Add Patient">

</form>