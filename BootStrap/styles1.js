
console.log("Welcome to the Community Portal");

window.onload = () => {
    alert("Page fully loaded!");
};


const eventName = "Community Clean-Up";
const eventDate = "2025-06-01";
let seatsAvailable = 30;

console.log(`${eventName} is on ${eventDate}. Seats available: ${seatsAvailable}`);


seatsAvailable--;
console.log(`One person registered. Remaining seats: ${seatsAvailable}`);
const today = new Date("2025-05-27");
const events = [
    { name: "Music Fest", date: "2025-06-15", seats: 10 },
    { name: "Art Walk", date: "2025-05-15", seats: 0 },
    { name: "Tech Meetup", date: "2025-06-05", seats: 25 }
];

events.forEach(event => {
    const eventDate = new Date(event.date);
    if (eventDate > today && event.seats > 0) {
        console.log(`✅ ${event.name} on ${event.date} - Seats: ${event.seats}`);
    } else {
        console.log(`❌ ${event.name} is unavailable`);
    }
});

function register(eventName) {
    try {
        const event = events.find(e => e.name === eventName);
        if (!event || event.seats <= 0) throw new Error("Cannot register. Event full or not found.");
        event.seats--;
        console.log(`Registered for ${event.name}. Seats left: ${event.seats}`);
    } catch (err) {
        console.error(err.message);
    }
}

function addEvent(name, date, seats, category) {
    events.push({ name, date, seats, category });
}

function registerUser(eventName) {
    register(eventName);
}

function filterEventsByCategory(category) {
    return events.filter(e => e.category === category);
}


function createCategoryTracker() {
    const counts = {};
    return function registerCategory(category) {
        counts[category] = (counts[category] || 0) + 1;
        return counts[category];
    };
}

const trackCategory = createCategoryTracker();
trackCategory("music"); 
trackCategory("music"); 


function dynamicSearch(events, callback) {
    return events.filter(callback);
}


const upcomingMusicEvents = dynamicSearch(events, e => e.category === "music" && new Date(e.date) > today);
function Event(name, date, seats, category) {
    this.name = name;
    this.date = new Date(date);
    this.seats = seats;
    this.category = category;
}

Event.prototype.checkAvailability = function () {
    return this.seats > 0 && this.date > today;
};

const eventObj = new Event("Workshop", "2025-06-10", 5, "education");
console.log(eventObj.checkAvailability()); 

console.log(Object.entries(eventObj)); 
