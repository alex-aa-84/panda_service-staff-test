package wwf.org.staff.model;

import lombok.Data;

import java.util.Date;


@Data
public class User {

    private Long id;
    private Tenant tenant;
    private String oid;
    private String userPrincipalName;
    private String displayName;
    private String surname;
    private String givenName;
    private String jobTitle;
    private String mail;
    private String mobilePhone;
    private String officeLocation;
    private String preferredLanguage;
    PermissionTenant permissionsTenant;

    private Integer attribute1;
    private Integer attribute2;
    private Integer attribute3;
    private Integer attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private Date attribute9 ;
    private Date attribute10;
    private String status;
    private Long create_by;
    private Date creation_date;
    private Long last_update_by;
    private Date last_update_date;
}
