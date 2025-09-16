# Connectly - Contact Management Application

**Connectly** is a web-based contact management application that allows users to **store, manage, and organize their contacts** efficiently. Built with **Spring Boot**, **Spring Data JPA**, **Spring Security**, **MySQL**, and **Thymeleaf**, the app provides a secure and user-friendly interface for managing personal or professional contacts.

---

## **Technologies Used**

- **Backend:** Java, Spring Boot, Spring Data JPA, Spring Security  
- **Frontend:** Thymeleaf, HTML, CSS (styled for clean UI)  
- **Database:** MySQL  
- **Authentication:** Login via username/password, OAuth2 login using **Google** and **GitHub**  
- **Email Service:** MailTrap integration for email notifications  
- **Deployment:** Hosted on **AWS EC2**  

---

## **Features**

- **User Authentication:** Secure login using Spring Security with optional Google and GitHub OAuth2 integration.  
- **Contact Management:** Add, update, delete, and view contacts.  
- **Email Notifications:** Send notifications via integrated MailTrap email service.  
- **Responsive UI:** Clean and intuitive interface using Thymeleaf and CSS.  
- **Secure Data Management:** All contact data is securely stored in MySQL with proper encryption and validation.  
- **Deployment:** Application is deployed and accessible on **AWS EC2**.  

---

## **Application Structure**

1. **User Management:** Handles user registration, login, and profile management.  
2. **Contact Management:** CRUD operations on contacts with fields like name, phone, email, and address.  
3. **Email Service:** Sends notifications when a new contact is added.  
4. **Frontend:** Thymeleaf templates for dynamic content rendering and responsive UI.  
5. **Security:** Spring Security for authentication, authorization, and OAuth2 login.  

---

## **Setup Instructions**

1. Clone the repository.  
2. Configure **MySQL** database and update `application.properties` with database credentials.  
3. Configure **MailTrap** for email notifications.  
4. Build the project using Maven:  
5. Run the Spring Boot application : mvn spring-boot:run
