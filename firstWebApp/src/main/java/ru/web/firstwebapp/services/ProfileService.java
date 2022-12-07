package ru.web.firstwebapp.services;

import ru.web.firstwebapp.models.User;
import ru.web.firstwebapp.security.details.CustomUserDetails;

public interface ProfileService {
    User getCurrent(CustomUserDetails customUserDetails);
}
