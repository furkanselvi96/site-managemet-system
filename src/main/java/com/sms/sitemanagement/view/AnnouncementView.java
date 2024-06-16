package com.sms.sitemanagement.view;


import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("announcements")
public class AnnouncementView extends VerticalLayout {

    public AnnouncementView() {
        H1 title = new H1("Duyurular");
        add(title);

        AnnouncementList announcementList = new AnnouncementList();
        add(announcementList);
    }

    private static class AnnouncementList extends VerticalLayout {
        public AnnouncementList() {
            setPadding(true);
            setMargin(true);
            setSpacing(true);
            setWidth("100%");

            add(new AnnouncementComponent("System Maintenance Announcement", "June 20, 2024"));
            add(new AnnouncementComponent("New Features Added", "June 15, 2024"));
            add(new AnnouncementComponent("User Information Update", "June 10, 2024"));
        }
    }

    //TODO: -> vaadin Card layout vevya component ekle duyurular için.Mesajları topla tek classta static
    private static class AnnouncementComponent extends VerticalLayout {
        public AnnouncementComponent(String title, String date) {
            setPadding(true);
            setMargin(true);
            setSpacing(true);
            setWidth("100%");

            H1 titleLabel = new H1(title);
            add(titleLabel);

            add(date);
        }
    }
}

