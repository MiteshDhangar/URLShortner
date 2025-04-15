# 🔗 URL Shortener App (ShortNest)

A full-stack URL Shortener application built with **React** (frontend) and **Spring Boot** (backend), featuring **JWT authentication**, **Dockerized backend**, and deployed using **Netlify** and **Render**.

## 🚀 Live Demo

👉 [shortnest.netlify.app](https://shortnest.netlify.app/)

---

## 📌 Features

- 🔐 **User Authentication**
  - Register & Login functionality
  - JWT token-based secured endpoints

- ✂️ **URL Shortening**
  - Input any long URL and get a short version
  - Authenticated and public usage

- 🧾 **User Dashboard**
  - View list of your shortened URLs
  - Track original and short URLs

- 📦 **Backend API**
  - REST APIs built with Spring Boot
  - Secure endpoints using Spring Security + JWT

- 📁 **Deployment**
  - Frontend hosted on Netlify
  - Backend hosted on Render
  - Dockerized backend for consistency

---

## 🛠️ Tech Stack

| Frontend | Backend     | Security | Deployment             | Tools                         |
|----------|-------------|----------|-------------------------|-------------------------------|
| React    | Spring Boot | JWT      | Netlify (Frontend), Render (Backend) | Docker, Postman, IntelliJ, VS Code |

---

## 💡 What I Learned

- 🛡️ **JWT & Spring Security**  
  Implemented JWT authentication and filters to secure REST APIs.

- 🔄 **JWT Token Handling**  
  Worked with parsing, validating, and passing JWTs between backend and frontend.

- 🌐 **CORS Handling**  
  Solved CORS errors caused by domain differences between frontend and backend.

- ⚙️ **Backend Integration**  
  Learned how to consume REST APIs in React using `axios`, manage responses, and handle errors.

- 🚀 **Deployment**  
  First time deploying a full-stack project — understood Render’s cold start delays, Netlify’s redirect rules, and how to connect both sides of the app.

---

## 😓 Challenges Faced

- 🔐 **JWT & Security Flow**  
  Had to configure JWT filters, handle exceptions properly, and debug Spring Security blocking endpoints.

- 🔄 **Frontend-Backend Communication**  
  Faced initial issues in handling tokens, headers, and axios calls between both layers.

- 🌍 **CORS Errors**  
  Took time to set proper `allowedOrigins`, use `@CrossOrigin`, and debug preflight issues.

- 🐳 **Dockerization**  
  Packaged the backend as a Docker image for consistency and future deployment scenarios.

- ⚙️ **Deployment Issues**  
  Faced Netlify 404s due to missing `_redirects` file, Render API delays, and environment variable mismatches.

---
