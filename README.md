
# TCI-JAVA TEST

Servicio Rest con el uso de: 
Spring framework 3.1.3
Java 11
Gradle
Spring Security
JPA
H2 Database



## API Reference
```
Se implemento una seguridad basica protegiendo los endpoints bajo un sistema de roles
GETS accesibles con rol "USER" Y "ADMIN"
POST, PUT, DELETE accesibles con rol "ADMIN"
ROL USER: username->user password->user
ROL ADMIN: username->admin password->admin
```
#### Registrar Empresa

```http
  POST /TCI/empresas/registrar
``` 
#### Listar ultimas tres empresas

```http
  GET /TCI/empresas/listar/ultimasTres
``` 
#### Listar ultimas empresas especificando la cantidad

```http
  GET /TCI/empresas/listar/ultimos/{cantidad}
```

#### Listar Empresa por Id

```http
  GET /TCI/empresas/listar/{id}
```
#### Listar todas las Empresas

```http
  GET /TCI/empresas/listar
```
#### Editar una Empresa por Id

```http
  GET /TCI/empresas/edit/{id}
```
#### Elminar una Empresa por Id

```http
  GET /TCI/empresas/delete/{id}
```

