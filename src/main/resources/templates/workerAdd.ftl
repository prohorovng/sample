
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
        <legend>Add worker</legend>
        <form name="worker" action="" method="POST">
            First name:<@spring.formInput "workerForm.name" "" "text"/>
            <br>First name:<@spring.formInput "workerForm.occupation" "" "text"/>
            <br>First name:<@spring.formInput "workerForm.salary" "" "text"/>
                        <br>

            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
