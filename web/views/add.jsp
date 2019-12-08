<%--
  Created by IntelliJ IDEA.
  User: Aleksey
  Date: 08.12.2019
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Autobase</title>
</head>

<body>
<div>
    <h1>Autobase</h1>
</div>

<div>
    <div>
        <div>
            <h2>Add vehicle</h2>
        </div>

        <form method="post">
            <label>Make:
                <input type="text" name="make"><br />
            </label>
            <label>Model:
                <input type="text" name="model"><br />
            </label>
            <label>Price:
                <input type="number" name="price"><br />
            </label>
            <label>Fuel consumption:
                <input type="number" name="fuelConsumption" step="0.1"><br />
            </label>
            <label>Power:
                <input type="number" name="power"><br />
            </label>
            <label>Year:
                <input type="number" min="1980" max="2019" step="1" name="year"><br />
            </label>
            <select name="fuelType">
                <option value="DIESEL">DIESEL</option>
                <option value="GAS">GAS</option>
                <option value="PETROL">PETROL</option>
            </select>
            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/vehicles'">Back to main</button>
</div>
</body>
</html>
