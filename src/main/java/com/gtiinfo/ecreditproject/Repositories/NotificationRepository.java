package com.gtiinfo.ecreditproject.Repositories;

import com.gtiinfo.ecreditproject.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NotificationRepository  extends JpaRepository<Notification, Long>{

}