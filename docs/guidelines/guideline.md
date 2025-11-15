# 📌 Guidelines — Nommage & Git

## 1️⃣ Nommages (Java / Spring Boot)

### 🎯 Classes
- UpperCamelCase
- Nommer selon le rôle métier  
  Exemples : `UserController`, `ProductService`, `OrderEntity`

### 🔢 Méthodes & attributs
- lowerCamelCase
- Noms explicites, verbes d’action pour méthodes  
  Exemples : `calculateTotal()`, `findById()`, `renameProduct()`

### 🧱 Packages
- minuscules, organisés par couches logiques  
  Exemples : `domain`, `application`, `infrastructure`, `web`  
  Exemple complet : `com.company.project.domain.product`

### 🗄️ Entités JPA
- Suffixer par `Entity` si ambigu  
  Exemples : `UserEntity`, `OrderEntity`

### 🧾 DTO
- Suffixes : `Request`, `Response`, `DTO`  
  Exemples : `ProductCreateRequest`, `UserResponse`

### ⚙️ Interfaces & implémentations
- Préférer suffixer l’implémentation plutôt que préfixer l’interface  
  ✅ `EmailService` + `EmailServiceImpl`  
  ❌ `IEmailService`

### 🚨 Exceptions
- Suffixe `Exception`  
  Exemple : `ProductNotFoundException`

---

## 2️⃣ Conventions Git

### 🏁 Branches
- Format : `type/feature-name`  
  Exemples :
    - `feat/add-login`
    - `fix/order-bug`
    - `refactor/user-service`

### ✅ Commits — Conventional Commits
- Format : `type(scope): subject`
- Types usuels :  
  `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`, `perf`, `build`, `ci`

Exemples :
- `feat(product): add create product endpoint`
- `fix(user): correct null pointer on login`
- `docs(readme): update project instructions`

Règles :
- Sujet à l’impératif, concis (anglais recommandé)  
  ✅ `Add price validation`  
  ❌ `Added` / `Adds` / `Fixing`
- PR = 1 objectif
- `BREAKING CHANGE:` si l’API publique change
- Lier les issues : `Closes #42`

### 🔀 Pull Requests
- Titre : `type(scope): objectif`
- Description : Pourquoi + Comment + Impacts
- Discussions de code encouragées

### 🔒 Merge
- **Squash & Merge** recommandé → un commit par PR
- Historique linéaire : rebase si nécessaire

---

## 3️⃣ Langue & style des messages
- Anglais recommandé
- Style impératif, clair et factuel
- Pas d’emojis dans les commits (OK dans PR)

---

## ✅ Résumé rapide
- Classes : `UpperCamelCase` → `OrderService`
- Méthodes/Champs : `lowerCamelCase` → `calculateTotal`
- DTO : suffixes `Request` / `Response`
- Exceptions : suffixe `Exception`
- Branches : `type/feature-name` → `feat/add-order`
- Commits : `type(scope): subject` → `fix(api): correct mapping`
- Merge : Squash & Merge, PR petite et ciblée

---
✅ Guidelines concises prêtes à l’emploi ✅
