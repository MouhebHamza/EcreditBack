package com.gtiinfo.ecreditproject.services;


import com.gtiinfo.ecreditproject.entities.Notification;
import com.gtiinfo.ecreditproject.entities.RendezVous;
import com.gtiinfo.ecreditproject.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface NotificationService {

    void newNotification(String title, String message, String url, User user);

    void markAsRead(int notificationId, int userId);

    void markAllAsRead(int userId);

    Notification getNotificationById(int notificationId);

    List<Notification> getAll(int userId);

    List<Notification> getUnreadNotifications(int userId);

    void newAppointmentFinishedNotification(RendezVous appointment, boolean sendEmail);

    void newAppointmentRejectionRequestedNotification(RendezVous appointment, boolean sendEmail);

    void newNewAppointmentScheduledNotification(RendezVous appointment, boolean sendEmail);

    void newAppointmentCanceledNotification(RendezVous appointment, boolean sendEmail);

    void newAppointmentRejectionAcceptedNotification(RendezVous appointment, boolean sendEmail);




}