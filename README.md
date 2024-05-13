# BACKEND-NOTES

Notes App Backend

## Tech Stack

**Technologies:** Java, Spring Boot 3, Jason Web Token, Sping Security 6

## Installation

Clone the project and access it

```bash
  git clone https://github.com/luisxsssx/backend-notes.git

  cd backend-notes
```
Install the project

```bash
  mvn spring-boot:build

  mvn spring-boot:run
```

## API operation

### User operations
    
```http
  POST /auth/register/admin
  POST /auth/register/user
```

| Parameter    | Type     | Description       |
|:-------------| :------- |:------------------|
| `username`   | `string` | User's username   |
| `password`   | `string` | User's password   |
| `first_name` | `string` | User's first_name |
| `last_name`  | `string` | User's last_name  |
| `email`      | `string` | User's email      |

#### Get the users (only if you have ADMIN privileges)

```http
  GET /admin/usr
```

#### Update user

```http
  PUT /usr/{id}
```
| Parameter  | Type     | Description     |
|:-----------| :------- |:----------------|
| `username` | `string` | User username   |
| `password` | `string` | User's password |

#### Delete user

```http
  DELETE /dl/{id}
```
| Parameter  | Type      | Description           |
|:-----------|:----------|:----------------------|
| `id`       | `integer` | **Required**. User id |


#### Login

```http
  POST /auth/login
```

| Parameter  | Type     | Description     |
|:-----------| :------- |:----------------|
| `username` | `string` | User username   |
| `password` | `string` | User's password |

### Notes operations

#### Create note

```http
   POST /note/sv
```

| Parameter  | Type     | Description |
|:-----------| :------- |:------------|
| `title`    | `string` | Note title  |
| `noteBody` | `string` | Note body   |

#### Get Note

```http
   GET /note/read
```

#### Delete Note

```http
   DELETE /note/dl/{id}
```

| Parameter  | Type      | Description           |
|:-----------|:----------|:----------------------|
| `id`       | `integer` | **Required**. Note id |

#### Update Note

```http
   PUT note/upd/{id}
```
| Parameter  | Type     | Description |
|:-----------| :------- |:------------|
| `title`    | `string` | Note title  |
| `noteBody` | `string` | Note body   |
