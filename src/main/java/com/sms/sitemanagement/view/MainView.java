package com.sms.sitemanagement.view;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("")
public class MainView extends AppLayout {

    public MainView() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Yeşilgöl Sitesi");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        SideNav nav = initializeSideNav();

        Scroller scroller = new Scroller(nav);
        scroller.setClassName(LumoUtility.Padding.SMALL);

        VerticalLayout content = new VerticalLayout();
        content.add(new H1("Ana Sayfa İçeriği"));

        addToDrawer(scroller);
        addToNavbar(toggle, title);
        setContent(content);
    }

    private SideNav initializeSideNav() {
        SideNav sideNav = new SideNav();
        sideNav.addItem(
                new SideNavItem("Login", "/login", VaadinIcon.USER.create()),
                new SideNavItem("Duyurular", "/announcements", VaadinIcon.CART.create()),
                new SideNavItem("Customers", "/customers", VaadinIcon.USER_HEART.create()),
                new SideNavItem("Products", "/products", VaadinIcon.PACKAGE.create()),
                new SideNavItem("Documents", "/documents", VaadinIcon.RECORDS.create()),
                new SideNavItem("Tasks", "/tasks", VaadinIcon.LIST.create()),
                new SideNavItem("Analytics", "/analytics", VaadinIcon.CHART.create()));
        return sideNav;
    }

    private void initializeMainView() {

    }

}

