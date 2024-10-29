<h1>ParkSafe</h1>

<p><strong>ParkSafe</strong> is a simple Java car parking management system that demonstrates Object-Oriented Programming (OOP) principles.</p>

<h2>Features</h2>
<ul>
    <li><strong>Standard and VIP Parking</strong>: Manage regular and VIP parking spots.</li>
    <li><strong>Parking Management</strong>: Centralized operations for parking and removing cars.</li>
    <li><strong>OOP Principles</strong>:
        <ul>
            <li><strong>Encapsulation</strong>: Private fields with public access methods.</li>
            <li><strong>Inheritance</strong>: VIP parking spots extend standard parking functionality.</li>
            <li><strong>Polymorphism</strong>: Specialized methods for different parking types.</li>
        </ul>
    </li>
</ul>

<h2>Class Structure</h2>
<ol>
    <li><strong>Car</strong>: Represents a car with attributes like license plate and color.</li>
    <li><strong>ParkingSpot</strong>: Basic structure for parking spots.</li>
    <li><strong>VIPParkingSpot</strong>: Extends <code>ParkingSpot</code> for VIP functionality.</li>
    <li><strong>ParkingLot</strong>: Manages multiple parking spots.</li>
    <li><strong>ParkingManager</strong>: Interfaces with <code>ParkingLot</code> to manage operations.</li>
</ol>

<h2>Usage</h2>
<ol>
    <li><strong>Clone the Repository</strong>:
        <pre><code>git clone https://github.com/username/ParkSafe.git
cd ParkSafe
        </code></pre>
    </li>
    <li><strong>Run the Project</strong>: Compile and execute the main application.</li>
</ol>

<h2>Example</h2>
<pre><code>ParkingLot parkingLot = new ParkingLot(10);
ParkingManager manager = new ParkingManager(parkingLot);
Car myCar = new Car(&quot;ABC-123&quot;, &quot;Blue&quot;);
manager.parkCar(myCar);
manager.removeCar(&quot;ABC-123&quot;);
</code></pre>

<h2>Future Improvements</h2>
<ul>
    <li>Database integration for data persistence.</li>
    <li>GUI implementation for user-friendly interaction.</li>
</ul>

<h2>License</h2>
<p>MIT License.</p>

<h2>Contact</h2>
<p>For inquiries, reach out to the project creator.</p>
