# 🛒 E-Commerce Platform 🛍

## Infrastructure

[![Spring Cloud | Service Discovery](https://img.shields.io/badge/Spring%20Cloud-Service%20Discovery-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://github.com/sahil-me/ServiceDiscovery)
[![Spring Cloud | API Gateway](https://img.shields.io/badge/Spring%20Cloud-API%20Gateway-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://github.com/sahil-me/ApiGateway)

## Business Services

[![Microservice | User Service](https://img.shields.io/badge/Microservice-User%20Service-007EC6?style=for-the-badge&labelColor=555555&logo=spring&logoColor=white)](https://github.com/sahil-me/UserService)
[![Microservice | Product Service](https://img.shields.io/badge/Microservice-Product%20Service-007EC6?style=for-the-badge&labelColor=555555&logo=spring&logoColor=white)](https://github.com/sahil-me/ProductService)
[![Microservice | Payment Service](https://img.shields.io/badge/Microservice-Payment%20Service-007EC6?style=for-the-badge&labelColor=555555&logo=spring&logoColor=white)](https://github.com/sahil-me/PaymentService)
[![Microservice | Email Service](https://img.shields.io/badge/Microservice-Email%20Service-007EC6?style=for-the-badge&labelColor=555555&logo=spring&logoColor=white)](https://github.com/sahil-me/EmailService)

https://github.com/user-attachments/assets/dba5fe24-f68a-422a-a420-c246578d0ae5

> 🎥 Payment Service Demonstration!

---

## Table of Contents
- [Introduction](#introduction)
- [Architecture Diagram](#architecture-diagram)
- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [Product Requirements Document (PRD)](#product-requirements-document-prd)
  - [Functional Requirements](#functional-requirements)
    - [User Management](#1%EF%B8%8F⃣-user-management)
    - [Product Catalog](#2%EF%B8%8F⃣-product-catalog)
    - [Cart & Checkout](#3%EF%B8%8F⃣-cart--checkout)
    - [Order Management](#4%EF%B8%8F⃣-order-management)
    - [Payment](#5%EF%B8%8F⃣-payment)
    - [Authentication](#6%EF%B8%8F⃣-authentication)
  - [High-Level Design (HLD)](#high-level-design-hld)
    - [Architecture Components](#architecture-components)
      - [Load Balancers (LB)](#architecture-components)
      - [API Gateway](#architecture-components)
      - [Microservices Architecture](#architecture-components)
      - [Databases](#architecture-components)
      - [Message Broker (Kafka)](#architecture-components)
      - [Caching (Redis)](#architecture-components)
      - [Search & Analytics (Elasticsearch)](#architecture-components)      
  - [Typical Flow](#typical-flow)
    - [Part 1: Product Search](#part-1-product-search)
    - [Part 2: Add to Cart](#part-2-add-to-cart)
    - [Part 3: Checkout](#part-3-checkout)
- [Resources](#resources)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Introduction

A scalable and modular e-commerce platform built using a microservices architecture. The system is designed to handle core e-commerce functionalities such as product management, cart operations, order processing, payment integration, and user management through independently deployable backend services.

The project demonstrates real-world backend engineering concepts including RESTful APIs, database design, asynchronous communication, scalability, service abstraction, caching, payment gateway integration, and microservices-based system design using Spring Boot and related technologies.

---

## Architecture Diagram

<img width="637" height="777" alt="High-Level Architecture" src="https://github.com/user-attachments/assets/8c74709f-3f92-4d73-9142-62b3baa8aa89" />

---

## Project Structure

    E-Commerce-Platform/
    │
    ├── ServiceDiscovery/   # Eureka Service Registry
    ├── ApiGateway/         # API Gateway
    ├── UserService/        # User Management
    ├── ProductService/     # Product Catalog Management
    ├── PaymentService/     # Payment Integration
    └── EmailService/       # Email Notifications 

---

## Tech Stack

| Technology                         | Purpose                                  |
| ---------------------------------- | ---------------------------------------- |
| Java 17                            | Core Programming Language                |
| Spring Boot 3.4                    | Application Framework                    |
| Spring Web                         | RESTful API Development                  |
| Razorpay Java SDK                  | Razorpay Payment Gateway Integration     |
| Stripe Java SDK                    | Stripe Payment Gateway Integration       |
| Spring Cloud Netflix Eureka Client | Service Discovery                        |
| Lombok                             | Boilerplate Code Reduction               |
| Maven                              | Build Automation & Dependency Management |
| JUnit 5                            | Testing Framework                        |
| Spring Boot DevTools               | Development & Hot Reload Support         |
| IntelliJ IDEA                      | Integrated Development Environment       |

---

## Product Requirements Document (PRD)

### Functional Requirements

### 1️⃣ User Management
- **Registration**: Allow users to register via email or social media profiles.
- **Login**: Secure user login with credentials.
- **Profile Management**: Enable users to view and edit their profiles.
- **Password Reset**: Allow password resets through secure email links.

### 2️⃣ Product Catalog
- **Browsing**: Users can browse products by category.
- **Product Details**: Product pages include images, descriptions, specifications, and more.
- **Search**: Provide search functionality with keyword-based queries.

### 3️⃣ Cart & Checkout
- **Add to Cart**: Users can add products to their cart.
- **Cart Review**: View selected items with price, quantity, and totals.
- **Checkout**: Seamless process to finalize purchases, including delivery details and payment options.

### 4️⃣ Order Management
- **Order Confirmation**: Confirm orders with details after purchase.
- **Order History**: Allow users to view past orders.
- **Order Tracking**: Provide delivery status tracking.

### 5️⃣ Payment
- **Multiple Payment Options**: Support credit/debit cards, online banking, and other methods.
- **Secure Transactions**: Ensure secure payment handling.
- **Payment Receipt**: Generate receipts for successful payments.

### 6️⃣ Authentication
- **Secure Authentication**: Protect user data during login and active sessions.
- **Session Management**: Allow users to stay logged in until they log out or after a specified duration.

## High-Level Design (HLD)

### Architecture Components

1️⃣ **Load Balancers (LB)**: Distribute traffic across servers for high availability (e.g., AWS ELB).

2️⃣ **API Gateway**: Entry point for routing requests, managing rate limits, and handling authentication (e.g., Kong).

3️⃣ **Microservices**: Separate services for modular and scalable architecture.

4️⃣ **Databases**: MySQL and MongoDB for structured and unstructured data.

5️⃣ **Message Broker (Kafka)**: Enable asynchronous inter-service communication.

6️⃣ **Caching (Redis)**: Boost response times for frequently accessed data.

7️⃣ **Search & Analytics (Elasticsearch)**: Efficient product searches with advanced capabilities.

## Typical Flow

### Part 1: Product Search
1️⃣ User logs in and searches for a product.

2️⃣ Request passes through the Load Balancer to the API Gateway.

3️⃣ API Gateway routes the search request to the Product Catalog Service.

4️⃣ Product Catalog Service queries Elasticsearch for results.

### Part 2: Add to Cart
1️⃣ User adds a product to the cart.

2️⃣ Cart Service stores the item in MongoDB and produces a Kafka message.

### Part 3: Checkout
1️⃣ User checks out.

2️⃣ Order Management Service processes the order and sends a Kafka message.

3️⃣ Payment Service consumes the message to handle payment.

---

## Resources

[![Razorpay](https://img.shields.io/badge/Razorpay-Payment%20Links-0C73FE?style=for-the-badge&logo=razorpay&logoColor=white)](https://razorpay.com/docs/payments/payment-links/apis/)
[![Razorpay](https://img.shields.io/badge/Razorpay-Checkout%20Theme-0C73FE?style=for-the-badge&logo=razorpay&logoColor=white)](https://razorpay.com/docs/api/payments/payment-links/checkout-theme/)
[![Razorpay](https://img.shields.io/badge/Razorpay-Test%20Cards-0C73FE?style=for-the-badge&logo=razorpay&logoColor=white)](https://razorpay.com/docs/payments/payments/test-card-details/)
[![Razorpay](https://img.shields.io/badge/Razorpay-Java%20SDK-0C73FE?style=for-the-badge&logo=github&logoColor=white)](https://github.com/razorpay/razorpay-java)
[![Stripe](https://img.shields.io/badge/Stripe-Payment%20Links-635BFF?style=for-the-badge&logo=stripe&logoColor=white)](https://docs.stripe.com/api/payment-link)
[![Stripe](https://img.shields.io/badge/Stripe-Webhooks-635BFF?style=for-the-badge&logo=stripe&logoColor=white)](https://docs.stripe.com/webhooks#webhooks-def)
[![Stripe](https://img.shields.io/badge/Stripe-Testing-635BFF?style=for-the-badge&logo=stripe&logoColor=white)](https://docs.stripe.com/testing)
[![Stripe](https://img.shields.io/badge/Stripe-Java%20SDK-635BFF?style=for-the-badge&logo=github&logoColor=white)](https://github.com/stripe/stripe-java)
[![Spring](https://img.shields.io/badge/Spring-Dependency%20Injection-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Documentation-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)](https://docs.spring.io/spring-boot/index.html)
[![REST API](https://img.shields.io/badge/Spring-REST%20API-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/guides/gs/rest-service)
[![Java](https://img.shields.io/badge/Java-Exception%20Handling-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

---

## Contributing

Contributions are welcome. Before submitting changes, please review:
- [Contributing Guide](./Contributing.md)
- [Code of Conduct](./CODE_OF_CONDUCT.md)
- [Security Policy](./SECURITY.md)

---

## License
This project is licensed under the [Apache 2.0 License](./LICENSE).

---

## Author

[**Sahil Sharma**](https://github.com/sahil-me)

Thank you for exploring this project. If you find it helpful, consider giving the repository a ⭐ to support its continued development.

