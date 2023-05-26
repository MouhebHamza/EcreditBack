package com.gtiinfo.ecreditproject.controllers;


import com.gtiinfo.ecreditproject.entities.Notification;
import com.gtiinfo.ecreditproject.entities.User;
import com.gtiinfo.ecreditproject.services.NotificationService;
import com.gtiinfo.ecreditproject.services.UserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private  NotificationService notificationService;
    private  UserService userService;

//    public NotificationController(NotificationService notificationService, UserService userService) {
//        this.notificationService = notificationService;
//        this.userService = userService;
//    }
//
//    @GetMapping()
//    public String showUserNotificationList(Model model, @AuthenticationPrincipal User currentUser) {
//        model.addAttribute("notifications", userService.getUserById(currentUser.getId()).getNotifications());
//        return "notifications/listNotifications";
//    }
//
//    @GetMapping("/{notificationId}")
//    public String showNotification(@PathVariable("notificationId") int notificationId, @AuthenticationPrincipal User currentUser) {
//        Notification notification = notificationService.getNotificationById(notificationId);
//        notificationService.markAsRead(notificationId, Math.toIntExact(currentUser.getId()));
//        return "notification:" ;
//    }
//
//    @PostMapping("/markAllAsRead")
//    public String processMarkAllAsRead(@AuthenticationPrincipal User currentUser) {
//        notificationService.markAllAsRead(Math.toIntExact(currentUser.getId()));
//        return "redirect:/notifications";
//    }
}