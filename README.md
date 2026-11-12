# Expense service

Prosty serwis REST Spring Boot. Wydatki są przechowywane wyłącznie w pamięci procesu, więc znikają po jego ponownym uruchomieniu.

Uruchomienie:

```bash
mvn spring-boot:run
```

API:

- `GET /api/expenses` — pobiera wszystkie wydatki.
- `GET /api/expenses?name=zakupy` — wyszukuje po fragmencie opisu (bez rozróżniania wielkości liter). Parametr `description` działa jako jego alternatywa.
- `GET /api/expenses?amount=42.50` — wyszukuje po dokładnej kwocie.
- Filtry można łączyć, np. `GET /api/expenses?name=zakupy&amount=42.50`.
- `POST /api/expenses` — dodaje wydatek:

```json
{
  "description": "Zakupy spożywcze",
  "amount": 42.50
}
```

Identyfikator jest nadawany automatycznie. Opis nie może być pusty, a kwota musi być dodatnia.
