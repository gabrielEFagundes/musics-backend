<div align="center">
  <h1>Resonance - Backend</h1>
  This repository is dedicated for the server API for the <b>Resonance Project</b>
</div>

## 🤔 What's Resonance?
Resonance is a Music Streaming app made with Java and Kotlin, it's meant to be a place where anyone can share their musics and projects!

## ✨ Features
The Resonance API is dedicated exclusively to [Resonance Frontend](https://github.com/gabrielEFagundes/resonance-frontend)

That means it does not provides any features for any project that is not Resonance.

Checkout the **Resonance App** to use everything we have to offer!

## 🧑‍💻 Our team

<table align="center">
  <tr>
    <td align="center">
      <img src="https://avatars.githubusercontent.com/u/197654251?v=4" width="100" alt="Luis" /><br/>
      <strong>Eduardo Dias da Maia</strong><br/>
      <sub>Developer & Designer</sub>
    </td>
    <td align="center">
      <img src="https://avatars.githubusercontent.com/u/185841300?v=4" width="100" alt="Gabriel" /><br/>
      <strong>Gabriel Ehrat Fagundes</strong><br/>
      <sub>Lead Developer</sub>
    </td>
    <td align="center">
      <img src="https://avatars.githubusercontent.com/u/197653416?v=4" width="100" alt="Renan" /><br/>
      <strong>Matheus Alexandre de Castro</strong><br/>
      <sub>Developer & Designer</sub>
    </td>
  </tr>
</table>

## 🤝 Contributing
This project is educational-only and closed-source, you can see all the code, but we'll not accept any PRs for our app.

Still, we're very very thankful if you actually came here to contribute to Resonance!

## 🚩 Where to Start?
If you want to use the codebase for your own purposes, you're completely free to do that!

Start by cloning this repo:

```bash
git clone https://github.com/gabrielEFagundes/resonance-backend
```

Then, change the `src/main/resources/application.properties` file to your own database credentials.

> [!NOTE]
> You might need to change the drivers depending on which database you're using.
>
> By default, Resonance uses `PostgreSQL`.

```bash
spring.application.name=musics
server.port=8081

spring.datasource.url=YOUR_URL
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=org.postgresql.Driver # change this to align with your database

spring.datasource.hikari.connection-timeout=30000
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect # change this to align with your database
```

After that, you're good to go!
