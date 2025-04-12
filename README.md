# API Monitoring System

A lightweight and open-source API monitoring system built with **Spring Boot** (backend) and **Vue.js** (frontend). This system helps developers track API availability, response time, and status codes, providing alerts in case of failures.

## Features
- **API Health Monitoring**: Periodically checks the health of registered APIs.
- **Response Time Tracking**: Stores API response times and status codes.
- **Alert System**: Sends notifications via email or webhook when an API is down.
- **Dashboard**: Visualize API performance metrics using interactive charts.
- **User Authentication**: Secure login and API management.

## Tech Stack
- **Backend**: Spring Boot, Spring Scheduler, MyBatis, JWT Authentication
- **Frontend**: Vue.js, ECharts for data visualization
- **Database**: MySQL / PostgreSQL
- **Deployment**: Docker, Nginx, GitHub Actions for CI/CD

## Installation Guide
### Prerequisites
- Java 17+
- Node.js 16+
- MySQL / PostgreSQL
- Docker (optional for deployment)

### Backend Setup
```sh
git clone https://github.com/stack3mpty/api-monitoring-system.git
cd api-monitoring-system/backend

# Configure database settings in application.yml

# Build and run the Spring Boot application
mvn clean install
mvn spring-boot:run
```

### Frontend Setup
```sh
cd ../frontend
npm install
npm run dev
```

The frontend will be available at `http://localhost:5173/` and the backend at `http://localhost:8080/`.

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | User login and JWT authentication |
| POST | `/api/monitor` | Add a new API to monitor |
| GET | `/api/monitor/{id}` | Get API monitoring status |
| DELETE | `/api/monitor/{id}` | Remove an API from monitoring |

## Roadmap
- [ ] Implement webhook notifications (Slack, DingTalk, etc.)
- [ ] Add role-based access control
- [ ] Improve UI/UX with real-time data updates

## Contributing
We welcome contributions! Feel free to submit issues, fork the repo, and create pull requests.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Contact
- GitHub: https://github.com/stack3mpty/api-monitoring-system
- Email: stack3mpty@gmail.com

