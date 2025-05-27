CREATE DATABASE communityportal;
USE communityportal;

-- Creating tables for Community Event Portal
CREATE TABLE Users1 (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);
INSERT INTO Users1 (user_id, full_name, email, city, registration_date) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

use communityportal;
select * from Users1;

CREATE TABLE Events1 (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled') NOT NULL,
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);
INSERT INTO Events1 (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

use communityportal;
select * from Events1;

CREATE TABLE Sessions1 (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Sessions1 (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

use communityportal;
select * from Sessions1;

CREATE TABLE Registrations1 (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Registrations1 (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 3, 2, '2025-04-30'),
(4, 4, 2, '2025-04-28'),
(5, 5, 3, '2025-06-15');

use communityportal;
select * from Registrations1;

CREATE TABLE Feedback1 (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Feedback1 (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-06-11');


use communityportal;
select * from Feedback1;

CREATE TABLE Resources1 (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link') NOT NULL,
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

INSERT INTO Resources1 (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 1, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');

use communityportal;
select * from  Resources1;

use communityportal;
-- 1. User Upcoming Events
-- Show a list of all upcoming events a user is registered for in their city, sorted by date
SELECT 
    u.full_name AS user_name,
    u.city AS user_city,
    e.title AS event_title,
    e.start_date,
    e.end_date
FROM Users1 u
JOIN Registrations1 r ON u.user_id = r.user_id
JOIN Events1 e ON r.event_id = e.event_id
WHERE e.status = 'upcoming' 
    AND e.city = u.city
ORDER BY e.start_date;

-- 2. Top Rated Events
-- Identify events with the highest average rating, considering only those that have received at least 10 feedback submissions
SELECT 
    e.title,
    e.city,
    ROUND(AVG(f.rating), 2) AS avg_rating,
    COUNT(f.feedback_id) AS feedback_count
FROM Events1 e
JOIN Feedback1 f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title, e.city
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC, feedback_count DESC;

-- 3. Inactive Users
-- Retrieve users who have not registered for any events in the last 90 days
SELECT 
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    u.registration_date
FROM Users1 u
WHERE u.user_id NOT IN (
    SELECT DISTINCT r.user_id
    FROM Registrations1 r
    WHERE r.registration_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
);

-- 4. Peak Session Hours
-- Count how many sessions are scheduled between 10 AM to 12 PM for each event
SELECT 
    e.title AS event_title,
    e.city,
    COUNT(s.session_id) AS sessions_10am_to_12pm
FROM Events1 e
LEFT JOIN Sessions1 s ON e.event_id = s.event_id
    AND TIME(s.start_time) >= '10:00:00' 
    AND TIME(s.start_time) < '12:00:00'
GROUP BY e.event_id, e.title, e.city
ORDER BY sessions_10am_to_12pm DESC;

-- 5. Most Active Cities
-- List the top 5 cities with the highest number of distinct user registrations
SELECT 
    e.city,
    COUNT(DISTINCT r.user_id) AS distinct_user_registrations
FROM Events1 e
JOIN Registrations1 r ON e.event_id = r.event_id
GROUP BY e.city
ORDER BY distinct_user_registrations DESC
LIMIT 5;

-- 6. Event Resource Summary
-- Generate a report showing the number of resources (PDFs, images, links) uploaded for each event
SELECT 
    e.title AS event_title,
    e.city,
    SUM(CASE WHEN res.resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
    SUM(CASE WHEN res.resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
    SUM(CASE WHEN res.resource_type = 'link' THEN 1 ELSE 0 END) AS link_count,
    COUNT(res.resource_id) AS total_resources
FROM Events1 e
LEFT JOIN Resources1 res ON e.event_id = res.event_id
GROUP BY e.event_id, e.title, e.city
ORDER BY total_resources DESC;

-- 7. Low Feedback Alerts
-- List all users who gave feedback with a rating less than 3, along with their comments and associated event names
SELECT 
    u.full_name,
    u.email,
    e.title AS event_title,
    f.rating,
    f.comments,
    f.feedback_date
FROM Users1 u
JOIN Feedback1 f ON u.user_id = f.user_id
JOIN Events1 e ON f.event_id = e.event_id
WHERE f.rating < 3
ORDER BY f.feedback_date DESC, f.rating ASC;

-- 8. Sessions per Upcoming Event
-- Display all upcoming events with the count of sessions scheduled for them
SELECT 
    e.title AS event_title,
    e.city,
    e.start_date,
    e.end_date,
    COUNT(s.session_id) AS session_count
FROM Events1 e
LEFT JOIN Sessions1 s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title, e.city, e.start_date, e.end_date
ORDER BY session_count DESC, e.start_date;

-- 9. Organizer Event Summary
-- For each event organizer, show the number of events created and their current status
SELECT 
    u.full_name AS organizer_name,
    u.email AS organizer_email,
    SUM(CASE WHEN e.status = 'upcoming' THEN 1 ELSE 0 END) AS upcoming_events,
    SUM(CASE WHEN e.status = 'completed' THEN 1 ELSE 0 END) AS completed_events,
    SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) AS cancelled_events,
    COUNT(e.event_id) AS total_events
FROM Users1 u
JOIN Events1 e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name, u.email
ORDER BY total_events DESC;

-- 10. Feedback Gap
-- Identify events that had registrations but received no feedback at all
SELECT 
    e.title AS event_title,
    e.city,
    e.status,
    e.start_date,
    COUNT(r.registration_id) AS registration_count
FROM Events1 e
JOIN Registrations1 r ON e.event_id = r.event_id
LEFT JOIN Feedback1 f ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL
GROUP BY e.event_id, e.title, e.city, e.status, e.start_date
ORDER BY registration_count DESC;

-- 11. Daily New User Count
-- Find the number of users who registered each day in the last 7 days
SELECT 
    registration_date,
    COUNT(user_id) AS new_users_count
FROM Users1
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)
GROUP BY registration_date
ORDER BY registration_date DESC;

-- 12. Event with Maximum Sessions
-- List the event(s) with the highest number of sessions
SELECT
    E.title AS event_title,
    COUNT(S.session_id) AS number_of_sessions
FROM Events AS E
JOIN Sessions1 AS S ON E.event_id = S.event_id
GROUP BY E.title
ORDER BY number_of_sessions DESC
LIMIT 1;

-- 13. Average Rating per City
-- Calculate the average feedback rating of events conducted in each city
SELECT 
    e.city,
    ROUND(AVG(f.rating), 2) AS avg_rating,
    COUNT(f.feedback_id) AS total_feedback_entries
FROM Events1 e
JOIN Feedback1 f ON e.event_id = f.event_id
GROUP BY e.city
ORDER BY avg_rating DESC;


-- 14. Most Registered Events
-- List top 3 events based on the total number of user registrations
SELECT 
    e.title AS event_title,
    e.city,
    e.status,
    e.start_date,
    COUNT(r.registration_id) AS registration_count
FROM Events1 e
JOIN Registrations1 r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title, e.city, e.status, e.start_date
ORDER BY registration_count DESC
LIMIT 3;


-- 15. Event Session Time Conflict
-- Identify overlapping sessions within the same event
SELECT 
    e.title AS event_title,
    s1.title AS session1_title,
    s1.speaker_name AS session1_speaker,
    s1.start_time AS session1_start,
    s1.end_time AS session1_end,
    s2.title AS session2_title,
    s2.speaker_name AS session2_speaker,
    s2.start_time AS session2_start,
    s2.end_time AS session2_end
FROM Events1 e
JOIN Sessions1 s1 ON e.event_id = s1.event_id
JOIN Sessions1 s2 ON e.event_id = s2.event_id
WHERE s1.session_id < s2.session_id
    AND s1.start_time < s2.end_time
    AND s2.start_time < s1.end_time
ORDER BY e.title, s1.start_time;

-- 16. Unregistered Active Users
-- Find users who created an account in the last 30 days but haven't registered for any events
SELECT 
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    u.registration_date,
    DATEDIFF(CURDATE(), u.registration_date) AS days_since_registration
FROM Users1 u
LEFT JOIN Registrations1 r ON u.user_id = r.user_id
WHERE u.registration_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)
    AND r.user_id IS NULL
ORDER BY u.registration_date DESC;

-- 17. Multi-Session Speakers
-- Identify speakers who are handling more than one session across all events
SELECT 
    s.speaker_name,
    COUNT(s.session_id) AS total_sessions,
    COUNT(DISTINCT s.event_id) AS events_spoken_at,
    GROUP_CONCAT(DISTINCT e.title ORDER BY e.title SEPARATOR ', ') AS events_list
FROM Sessions1 s
JOIN Events1 e ON s.event_id = e.event_id
GROUP BY s.speaker_name
HAVING COUNT(s.session_id) > 1
ORDER BY total_sessions DESC, events_spoken_at DESC;


-- 18. Resource Availability Check
-- List all events that do not have any resources uploaded
SELECT 
    e.title AS event_title,
    e.city,
    e.status,
    e.start_date,
    e.end_date
FROM Events1 e
LEFT JOIN Resources1 res ON e.event_id = res.event_id
WHERE res.resource_id IS NULL
ORDER BY e.start_date;


-- 19. Completed Events with Feedback Summary
-- For completed events, show total registrations and average feedback rating
SELECT 
    e.title AS event_title,
    e.city,
    e.start_date,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    ROUND(AVG(f.rating), 2) AS avg_rating,
    COUNT(f.feedback_id) AS feedback_count,
    ROUND((COUNT(f.feedback_id) * 100.0 / COUNT(DISTINCT r.registration_id)), 2) AS feedback_response_rate_percent
FROM Events1 e
LEFT JOIN Registrations1 r ON e.event_id = r.event_id
LEFT JOIN Feedback1 f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title, e.city, e.start_date
HAVING COUNT(DISTINCT r.registration_id) > 0
ORDER BY avg_rating DESC;

-- 20. User Engagement Index
-- For each user, calculate how many events they attended and how many feedbacks they submitted
SELECT 
    u.full_name,
    u.email,
    u.city,
    COUNT(DISTINCT r.event_id) AS events_registered,
    COUNT(DISTINCT f.event_id) AS events_feedback_given,
    CASE 
        WHEN COUNT(DISTINCT r.event_id) > 0 
        THEN ROUND((COUNT(DISTINCT f.event_id) * 100.0 / COUNT(DISTINCT r.event_id)), 2)
        ELSE 0 
    END AS engagement_percentage
FROM Users1 u
LEFT JOIN Registrations1 r ON u.user_id = r.user_id
LEFT JOIN Feedback1 f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name, u.email, u.city
ORDER BY engagement_percentage DESC, events_registered DESC;


-- 21. Top Feedback Providers
-- List top 5 users who have submitted the most feedback entries
SELECT 
    u.full_name,
    u.email,
    u.city,
    COUNT(f.feedback_id) AS feedback_entries_count,
    ROUND(AVG(f.rating), 2) AS avg_rating_given
FROM Users1 u
JOIN Feedback1 f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name, u.email, u.city
ORDER BY feedback_entries_count DESC, avg_rating_given DESC
LIMIT 5;

-- 22. Duplicate Registrations Check
-- Detect if a user has been registered more than once for the same event
SELECT 
    u.full_name,
    u.email,
    e.title AS event_title,
    e.city,
    COUNT(r.registration_id) AS duplicate_registrations,
    GROUP_CONCAT(r.registration_date ORDER BY r.registration_date SEPARATOR ', ') AS registration_dates
FROM Users1 u
JOIN Registrations1 r ON u.user_id = r.user_id
JOIN Events1 e ON r.event_id = e.event_id
GROUP BY u.user_id, e.event_id, u.full_name, u.email, e.title, e.city
HAVING COUNT(r.registration_id) > 1
ORDER BY duplicate_registrations DESC;

-- 23. Registration Trends
-- Show a month-wise registration count trend over the past 12 months
SELECT 
    DATE_FORMAT(r.registration_date, '%Y-%m') AS month_year,
    MONTHNAME(r.registration_date) AS month_name,
    YEAR(r.registration_date) AS year,
    COUNT(r.registration_id) AS registration_count
FROM Registrations1 r
WHERE r.registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY DATE_FORMAT(r.registration_date, '%Y-%m'), MONTHNAME(r.registration_date), YEAR(r.registration_date)
ORDER BY month_year DESC;

-- 24. Average Session Duration per Event
-- Compute the average duration (in minutes) of sessions in each event
SELECT 
    e.title AS event_title,
    e.city,
    COUNT(s.session_id) AS total_sessions,
    ROUND(AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)), 2) AS avg_session_duration_minutes,
    MIN(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS shortest_session_minutes,
    MAX(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS longest_session_minutes
FROM Events1 e
JOIN Sessions1 s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title, e.city
ORDER BY avg_session_duration_minutes DESC;

-- 25. Events Without Sessions
-- List all events that currently have no sessions scheduled under them
SELECT 
    e.title AS event_title,
    e.city,
    e.status,
    e.start_date,
    e.end_date,
    u.full_name AS organizer_name
FROM Events1 e
JOIN Users1 u ON e.organizer_id = u.user_id
LEFT JOIN Sessions1 s ON e.event_id = s.event_id
WHERE s.session_id IS NULL
ORDER BY e.start_date, e.title;


-- 26. Event Popularity Score
-- Calculate a popularity score based on registrations, feedback, and ratings
SELECT 
    e.title AS event_title,
    e.city,
    e.status,
    COUNT(DISTINCT r.user_id) AS unique_registrations,
    COUNT(f.feedback_id) AS feedback_count,
    COALESCE(ROUND(AVG(f.rating), 2), 0) AS avg_rating,
    (COUNT(DISTINCT r.user_id) * 0.4 + 
     COUNT(f.feedback_id) * 0.3 + 
     COALESCE(AVG(f.rating), 0) * 0.3) AS popularity_score
FROM Events1 e
LEFT JOIN Registrations1 r ON e.event_id = r.event_id
LEFT JOIN Feedback1 f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title, e.city, e.status
ORDER BY popularity_score DESC;

-- 27. User Activity Timeline
-- Show user activity timeline with registration and feedback dates
SELECT 
    u.full_name,
    'Registration' AS activity_type,
    e.title AS event_title,
    r.registration_date AS activity_date,
    NULL AS rating
FROM Users1 u
JOIN Registrations1 r ON u.user_id = r.user_id
JOIN Events1 e ON r.event_id = e.event_id
UNION ALL
SELECT 
    u.full_name,
    'Feedback' AS activity_type,
    e.title AS event_title,
    f.feedback_date AS activity_date,
    f.rating
FROM Users1 u
JOIN Feedback1 f ON u.user_id = f.user_id
JOIN Events1 e ON f.event_id = e.event_id
ORDER BY full_name, activity_date DESC;
