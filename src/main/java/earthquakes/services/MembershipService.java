package earthquakes.services;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface MembershipService {

    /** check membership
     * @param oAuth2AuthenticationToken oauth token
     * @return is current logged in user a member but not an admin of the github org
     * */
    public boolean isMember(OAuth2AuthenticationToken oAuth2AuthenticationToken);

    /** checks if admin 
     * @param oAuth2AuthenticationToken oauth token
     * @return is current logged in user an admin of the github org 
     * */
    public boolean isAdmin(OAuth2AuthenticationToken oAuth2AuthenticationToken);

    /** checks if admin 
     * @param oAuth2AuthenticationToken oauth token
     * @return is current logged in user a member or an admin of the github org
     * */
    default public boolean isMemberOrAdmin(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return isMember(oAuth2AuthenticationToken) || isAdmin(oAuth2AuthenticationToken);
    }

    default public String role(OAuth2AuthenticationToken token) {
        if (token==null)
            return "Guest";
        if (isMember(token))
            return "Member";
        if (isAdmin(token))
            return "Admin";
        return "Guest";
    }

}
