<h1>ParkSafe</h1>

<p><strong>ParkSafe</strong> is a Java-based car parking management system that uses Object-Oriented Programming (OOP) principles to manage parking spaces, including standard and VIP spots. The system interacts with a PostgreSQL database to store and manage parking data such as cars, spots, and transactions.</p>

<h2>Features</h2>
<ul>
    <li><strong>Standard and VIP Parking</strong>: Manage both standard and VIP parking spots with special privileges for VIP users.</li>
    <li><strong>Database-Driven Parking Management</strong>: All parking data, including cars and spots, is stored and managed in a PostgreSQL database.</li>
    <li><strong>Parking Spot Availability</strong>: The system tracks the availability of parking spots in real-time, ensuring accurate data persistence and user interaction.</li>
    <li><strong>OOP Principles</strong>:
        <ul>
            <li><strong>Encapsulation</strong>: Classes for cars, parking spots, and transactions encapsulate their data and provide public methods to interact with it.</li>
            <li><strong>Inheritance</strong>: VIP parking spots extend the standard parking spot class to add specialized functionality.</li>
            <li><strong>Polymorphism</strong>: The system has methods that behave differently based on the type of parking spot (standard vs. VIP).</li>
        </ul>
    </li>
</ul>

<h2>Class Structure</h2>
<ol>
    <li><strong>Car</strong>: Represents a car with attributes such as license plate and color. Each car is associated with a parking transaction when it is parked.</li>
    <li><strong>ParkingSpot</strong>: Represents a parking spot with attributes such as spot number and whether it's occupied or available.</li>
    <li><strong>VIPParkingSpot</strong>: Inherits from <code>ParkingSpot</code>, with additional functionality specific to VIP spots.</li>
    <li><strong>ParkingLot</strong>: Manages a collection of parking spots and handles spot availability and car parking operations.</li>
    <li><strong>ParkingManager</strong>: Interfaces with <code>ParkingLot</code> to perform operations such as parking and unparking cars, checking availability, and managing parking transactions.</li>
    <li><strong>DatabaseConnection</strong>: Establishes a connection to a PostgreSQL database for managing cars, parking spots, and transactions.</li>
    <li><strong>Operations</strong>: Handles CRUD operations (Create, Read, Update, Delete) for cars and parking spots in the database.</li>
</ol>

<h2>Usage</h2>
<ol>
    <li><strong>Clone the Repository</strong>:
        <pre><code>git clone https://github.com/username/ParkSafe.git
cd ParkSafe
        </code></pre>
    </li>
    <li><strong>Set Up the Database</strong>: Ensure that the PostgreSQL database is set up with the appropriate tables for cars, parking spots, and transactions.</li>
    <li><strong>Run the Project</strong>: Compile and execute the main Java application. The system will prompt the user with a menu to manage parking operations.</li>
</ol>

<h2>How It Works</h2>
<ol>
    <li>The system initializes with 10 parking spots in the PostgreSQL database. These spots are automatically created when the system starts.</li>
    <li>Users can park a car by providing its license plate. The system checks for available spots, parks the car in the first available spot, and updates the database to reflect the new parking status.</li>
    <li>Users can unpark a car by providing its license plate. The system removes the car from its spot and updates the parking spot's status to available in the database.</li>
    <li>The system tracks parking transactions in the database, recording when a car is parked or removed.</li>
    <li>All data, including the list of parked cars and available parking spots, is retrieved and displayed from the database.</li>
</ol>

<h2>Future Improvements</h2>
<ul>
    <li>Integration of user authentication for VIP users and regular users.</li>
    <li>Graphical User Interface (GUI) to make interactions more user-friendly and intuitive.</li>
    <li>Advanced reporting and data analytics on parking transactions.</li>
</ul>

<h2>License</h2>
<p>MIT License.</p>

<h2>Contact</h2>
<p>For inquiries, reach out to the project creator via <a href="mailto:laulanyumbayire@gmail.com">laulanyumbayire@gmail.com</a>.</p>
