<!DOCTYPE html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3></h3>
<form action="calc" method="post">
    <input type="number" name="firstNum" placeholder="Write number">
    <input type="number" name="secondNum" placeholder="Write number">
    <button type="submit" name="operator" value="MINUS">-</button>
    <button type="submit" name="operator" value="PLUS">+</button>
    <button type="submit" name="operator" value="MULTIPLY">*</button>
    <button type="submit" name="operator" value="DIVIDE">\</button>
</form>
<#if result ??>
Answer: ${result}
</#if>
</body>