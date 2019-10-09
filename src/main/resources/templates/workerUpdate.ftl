
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Edit worker</legend>
        <form name="worker" action="" method="POST">
            First name:<@spring.formInput "workerForm.name" "" "text"/>
            <br>Occupation:<@spring.formInput "workerForm.occupation" "" "text"/>
            <br>Occupation:<@spring.formInput "workerForm.occupation" "" "text"/>
            <br>Speciality:<@spring.formSingleSelect "workerForm.speciality",mavs,"class='form-control'"/>
            <br>Salary:<@spring.formInput "workerForm.salary" "" "text"/>
                        <br>

            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>
