package com.example.Notifications.Notification.version;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationVersionRepository extends JpaRepository<NotificationVersion,Long> {
}
