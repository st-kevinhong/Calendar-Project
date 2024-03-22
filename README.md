# Calendar-Project
Utilizing Database &amp; Interfaces

### Summary
By creating database Schema and corresponding GUI, the user is able to acknowledge the
overview structure of the family calendar. This project includes project folder with java codes with
GUI and SQL code for overall Database Schema. By accessing via JAR file, user will be able to
access calendar GUI programmed by Java Swing and predict what to except on upcoming
projects.

### Specification
The goal of this project was planning the overall structure of back-end database and setting up
corresponding front-end for later assignments. This project includes Java project files and SQL
schema not yet connected with the interface. This project was designed in accordance with nine
requirements from the specification sheet. This part will go through overall structure, database
schema & specific implementation for the interface.

![image](https://github.com/st-kevinhong/Calendar-Project/assets/86182583/c29255fc-3b91-4f89-9f0d-152e3d5967d5)

### Design & Implementation
To satisfy functional requirement, I planned abstract structure of the interface first. By clarifying
what I need, I was able to get assume tables I need to create the calendar.

When I classified structure of GUI with functions, I noticed that they required different kinds of
database. The most important unit to this calendar is event and it could be classified by date for
calendar and book/modify/cancel event by the user. However, putting multiple participant into one
table first step of normalization and had to separate it. Also distinguishing between host and
participant was also needed to act differently in modifying and cancelling events. So, the major part
of data schema was user, event, calendar and defining its relations. I extended and divided the
database as test out mandatory functions. Below is the result of the data schema I designed.

![image](https://github.com/st-kevinhong/Calendar-Project/assets/86182583/4d6fb2a1-1d59-4fdb-af87-849b4789c604)

Tables: Accounts, Events, Attendees, MyEvents, MyHost Events, Requests, Calendar, CalendarEvents

Accounts: Entity needed for distinguishing user and assigning

Events: Every events registered are shown here.

Attendees: Attendees for each event is stored here.

MyEvents: Events I am attending are registed here and used for upcoming events & cancel events

MyHostEvents: This table exists to manipulate modify event.

Requests: This shows when other host invited me to event.

Calendar: This table is used to group events by date.

CalendarEvents: It is a middle table to connect calendar and events.

### Overview
Login Page
![image](https://github.com/st-kevinhong/Calendar-Project/assets/86182583/290ba58d-654c-44e5-b8d8-3031ea4426f6)

UserMenuUI & Event Details
![image](https://github.com/st-kevinhong/Calendar-Project/assets/86182583/cd0c1739-93bb-4ff0-8014-354cd0331c1e)
This part provides access to all other functions by button below. In addition, it shows reminders
for upcoming events. I placed it in the front screen because it is an urgent information for the
users.

Book & Accept Events
![image](https://github.com/st-kevinhong/Calendar-Project/assets/86182583/66037c13-488e-48f5-b594-1b7247404e1b)
Book: Explicitly, this part can book an event and invite family members. It will automatically
update and show members available for the specific schedule.

Accept: There are list of event that I am involved and I can either accept/decline the offer

Modify & Cancel Events
![image](https://github.com/st-kevinhong/Calendar-Project/assets/86182583/d552dbf0-9f9f-4b1f-b0a2-d6438114d83e)
Modify: After referencing information above (event you hosted), type in event ID for modification
and rewrite details for the event

Cancel Event: Although it can be erased by only typing event ID, being host or participant is
different. This is why I separated host data from participant. Functionalities to make there
differences will be done in the next API assignment.

View Event Lists, View Calendar
![image](https://github.com/st-kevinhong/Calendar-Project/assets/86182583/12d9607b-bd7f-483e-bb59-5cc53a3885ec)
View Event List will show all events in chronological order. Calendar view provides daily schedule
when the user press the specific date. It was completed by bringing in JCalendar library
