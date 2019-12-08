<%--
  Created by IntelliJ IDEA.
  User: Aleksey
  Date: 08.12.2019
  Time: 21:21
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
            <h2>Edit vehicle</h2>
        </div>

        <form method="post">
            <label>Make:
                <input type="text" name="make" value="${vehicle.getMake()}"><br />
            </label>
            <label>Model:
                <input type="text" name="model" value="${vehicle.getModel()}"><br />
            </label>
            <label>Price:
                <input type="number" name="price" value="${vehicle.getPrice()}"><br />
            </label>
            <label>Fuel consumption:
                <input type="number" name="fuelConsumption" step="0.1" value="${vehicle.getFuelConsumption()}"><br />
            </label>
            <label>Power:
                <input type="number" name="power" value="${vehicle.getPower()}"><br />
            </label>
            <label>Year:
                <input type="number" min="1980" max="2019" step="1" name="year" value="${vehicle.getYear()}"><br />
            </label>
            <label>Fuel type:
                <select name="fuelType">
                    <option selected hidden value="${vehicle.getFuelType().toString()}">${vehicle.getFuelType().toString()}</option>
                    <option value="DIESEL">DIESEL</option>
                    <option value="GAS">GAS</option>
                    <option value="PETROL">PETROL</option>
                </select>
            </label>
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
