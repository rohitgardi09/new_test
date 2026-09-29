FilterBasedLdapUserSearch ldapUserSearch = new FilterBasedLdapUserSearch(userSearchBase, userSearchFilter, contextSource);
ldapUserSearch.setSearchSubtree(true);
DirContextOperations userDetails;
try {
    userDetails = ldapUserSearch.searchForUser(loginRequest.getUserId());

    javax.naming.directory.Attributes allAttrs = userDetails.getAttributes();
    javax.naming.NamingEnumeration<String> attrIds = allAttrs.getIDs();
    StringBuilder allFields = new StringBuilder();
    while (attrIds.hasMore()) {
        String attrId = attrIds.next();
        allFields.append(attrId).append("=").append(userDetails.getStringAttribute(attrId)).append(System.lineSeparator());
    }

    String name = userDetails.getStringAttribute("cn");
    String email = userDetails.getStringAttribute("mail");
    String mobile1 = userDetails.getStringAttribute("mobile");
    String mobile2 = userDetails.getStringAttribute("telephoneNumber");
    String mobile3 = userDetails.getStringAttribute("homePhone");
    String mobile4 = userDetails.getStringAttribute("otherMobile");

    result.append("STAGE 3 RESULT: User found. Resolved DN: ").append(userDetails.getNameInNamespace()).append(System.lineSeparator());
    result.append("ADID entered: ").append(loginRequest.getUserId()).append(System.lineSeparator());
    result.append("Name: ").append(name).append(System.lineSeparator());
    result.append("Email: ").append(email).append(System.lineSeparator());
    result.append("mobile: ").append(mobile1).append(System.lineSeparator());
    result.append("telephoneNumber: ").append(mobile2).append(System.lineSeparator());
    result.append("homePhone: ").append(mobile3).append(System.lineSeparator());
    result.append("otherMobile: ").append(mobile4).append(System.lineSeparator());
    result.append("ALL ATTRIBUTES:").append(System.lineSeparator());
    result.append(allFields);

    log.info(result.toString());
} catch (UsernameNotFoundException ex) {
    msg = "STAGE 3 FAILED - CONFIG ISSUE: user '" + loginRequest.getUserId() + "' not found. Check user-search-base/user-search-filter. Msg: " + ex.getMessage();
    log.error(msg, ex);
    return result.append(msg).toString();
} catch (Exception ex) {
    msg = "STAGE 3 FAILED - UNKNOWN: Type: " + ex.getClass().getName() + ", Msg: " + ex.getMessage();
    log.error(msg, ex);
    return result.append(msg).toString();
}











// STAGE 3: Search for the user via configured search-base/search-filter
FilterBasedLdapUserSearch ldapUserSearch = new FilterBasedLdapUserSearch(userSearchBase, userSearchFilter, contextSource);
ldapUserSearch.setSearchSubtree(true);
DirContextOperations userDetails;
try {
    userDetails = ldapUserSearch.searchForUser(loginRequest.getUserId());

    String name = userDetails.getStringAttribute("cn");
    String email = userDetails.getStringAttribute("mail");
    String mobile = userDetails.getStringAttribute("mobile");

    msg = "STAGE 3 RESULT: User found. Resolved DN: " + userDetails.getNameInNamespace()
            + " | Name: " + name
            + " | Email: " + email
            + " | Mobile: " + mobile;
    log.info(msg);
    result.append(msg).append("\n");
} catch (UsernameNotFoundException ex) {
    msg = "STAGE 3 FAILED - CONFIG ISSUE: user '" + loginRequest.getUserId() + "' not found. Check user-search-base/user-search-filter. Msg: " + ex.getMessage();
    log.error(msg, ex);
    return result.append(msg).toString();
} catch (Exception ex) {
    msg = "STAGE 3 FAILED - UNKNOWN: Type: " + ex.getClass().getName() + ", Msg: " + ex.getMessage();
    log.error(msg, ex);
    return result.append(msg).toString();
}








sagar.rathod.cedge@sbi.co.in; bhoopendra.rajput.cedge@sbi.co.in; ranu.jain.cedge@sbi.co.in; namdev.gadve.cedge@sbi.co.in; vishnu.ghelot@sbi.co.in; prasad.gaikwad@sbi.co.in; faizan.pinjari.cedge@sbi.co.in; sourabh.dutta@sbi.co.in; vishal.bansal@sbi.co.in; aniket.taksande@sbi.co.in; vikram.deshpande.cedge@sbi.co.in; dipesh.bhanushali.cedge@sbi.co.in; neeraj.durgapal.cedge@sbi.co.in; karan.thakkar.cedge@sbi.co.in; sunadmin2.sbiepay@sbi.co.in; tech.sbiepay@sbi.co.in; noc.sbiepay@sbi.co.in; product.sbiepay@sbi.co.in; team.epay@sbi.co.in; devops.sbiepay@sbi.co.in


adsupport.corp@sbi.co.in; ghanshyam.baboo.cedge@sbi.co.in


Thank You – LDAP Connectivity and Authentication Successfully Resolved
Hi All,
Thank you everyone for your valuable support and cooperation in resolving the LDAP connectivity and authentication issue.
With your help, we have successfully established the LDAP connection, verified the service account bind, and completed user authentication testing successfully.
I sincerely appreciate everyone's time, guidance, and assistance throughout the troubleshooting process.
Thanks & Regards,
Rohit Gardi
