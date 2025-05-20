<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Expense Income Tracker</title>
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f9f9f9;
        }
        header {
            background-color: #4a90e2;
            color: white;
            padding: 15px 30px;
            font-size: 24px;
            font-weight: bold;
            text-align: center;
            letter-spacing: 1.5px;
        }
        .container {
            display: flex;
            height: calc(100vh - 60px);
        }
        nav.sidebar {
            background: #2f3e46;
            width: 250px;
            color: #cad2c5;
            padding-top: 20px;
            display: flex;
            flex-direction: column;
        }
        nav.sidebar a {
            color: #cad2c5;
            padding: 15px 30px;
            text-decoration: none;
            font-weight: 600;
            border-left: 4px solid transparent;
            transition: all 0.3s ease;
        }
        nav.sidebar a:hover,
        nav.sidebar a.active {
            background-color: #52796f;
            border-left: 4px solid #84a98c;
            color: white;
        }
        main.content {
            flex-grow: 1;
            padding: 30px;
            background: white;
            overflow-y: auto;
        }
        h2 {
            margin-top: 0;
            color: #333;
        }
        p {
            color: #555;
            line-height: 1.6;
        }
        footer {
            background: #4a90e2;
            color: white;
            text-align: center;
            padding: 10px 0;
            font-size: 14px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<header>
    Expense Income Tracker
</header>

<div class="container">
    <nav class="sidebar">
        <a href="wallets.jsp" class="active">Wallets</a>
        <a href="transactions.jsp">Transactions</a>
        <a href="reports.jsp">Reports</a>
        <a href="settings.jsp">Settings</a>
    </nav>

    <main class="content">
        <h2>Welcome to your Expense Income Tracker</h2>
        <p>Use the sidebar to navigate through wallets, transactions, and reports.</p>
        <p>This application helps you manage your finances by tracking your income and expenses efficiently.</p>
        <p>Click on "Wallets" to start managing your wallets, or "Transactions" to add/edit your income and expense records.</p>
    </main>
</div>

<footer>
    &copy; 2025 Expense Income Tracker. All rights reserved.
</footer>

</body>
</html>
