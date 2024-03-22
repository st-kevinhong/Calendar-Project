-- schema.sql

-- 사용자 정보
CREATE TABLE Accounts (
    UserID SERIAL PRIMARY KEY,
    Username VARCHAR(50) UNIQUE NOT NULL,
    Password VARCHAR(50) NOT NULL
    Email VARCHAR(150)
);

-- 이벤트 테이블
CREATE TABLE Events (
    EventID SERIAL PRIMARY KEY,
    Title VARCHAR(100) NOT NULL,
    Description TEXT,
    StartDate TIMESTAMP NOT NULL,
    EndDate TIMESTAMP NOT NULL,
    Location VARCHAR(255)
    -- Consider adding more constraints depending on the logic of your application
);

-- 캘린더 테이블
CREATE TABLE Calendars (
    CalendarID SERIAL PRIMARY KEY,
    UserID INTEGER REFERENCES Accounts(UserID),
    Name VARCHAR(255) NOT NULL,
    Description TEXT
);

-- 캘린더 이벤트 연결
CREATE TABLE CalendarEvents (
    CalendarEventID SERIAL PRIMARY KEY,
    CalendarID INTEGER REFERENCES Calendars(CalendarID),
    EventID INTEGER REFERENCES Events(EventID)
);

-- 참석자 테이블
CREATE TABLE Attendees (
    AttendeeID SERIAL PRIMARY KEY,
    EventID INTEGER REFERENCES Events(EventID),
    UserID INTEGER REFERENCES Accounts(UserID),
    ResponseStatus VARCHAR(50) -- e.g., "Accepted", "Declined", "Pending"
);

-- 요청 테이블
CREATE TABLE Requests (
    RequestID SERIAL PRIMARY KEY,
    UserID INTEGER REFERENCES Accounts(UserID),
    EventID INTEGER REFERENCES Events(EventID),
    RequestStatus VARCHAR(50) -- e.g., "Pending", "Accepted", "Declined"
);

-- 내 이벤트 조회
CREATE TABLE MyEvents (
    MyEventID SERIAL PRIMARY KEY,
    UserID INTEGER REFERENCES Accounts(UserID),
    EventID INTEGER REFERENCES Events(EventID)
);

-- 내가 개최한 이벤트
CREATE TABLE MyHostEvents (
    MyHostEventID SERIAL PRIMARY KEY,
    UserID INTEGER REFERENCES Accounts(UserID),
    CalendarID INTEGER REFERENCES Calendars(CalendarID)
    -- You can add additional columns for extra information specific to the events being hosted
);
