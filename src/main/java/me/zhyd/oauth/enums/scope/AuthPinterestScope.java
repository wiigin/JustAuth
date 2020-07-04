package me.zhyd.oauth.enums.scope;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pinterest 平台 OAuth 授权范围
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum AuthPinterestScope implements AuthScope {

    /**
     * {@code scope} 含义，以{@code description} 为准
     */
    READ_PUBLIC("read_public", "Use GET method on a user’s Pins, boards.", true),
    WRITE_PUBLIC("write_public", "Use PATCH, POST and DELETE methods on a user’s Pins and boards.", false),
    READ_RELATIONSHIPS("read_relationships", "Use GET method on a user’s follows and followers (on boards, users and interests).", false),
    WRITE_RELATIONSHIPS("write_relationships", "Use PATCH, POST and DELETE methods on a user’s follows and followers (on boards, users and interests).", false),
    ;

    private String scope;
    private String description;
    private boolean isDefault;

    public static List<AuthScope> getDefaultScopes() {
        AuthPinterestScope[] scopes = AuthPinterestScope.values();
        List<AuthScope> defaultScopes = new ArrayList<>();
        for (AuthPinterestScope scope : scopes) {
            if (scope.isDefault()) {
                defaultScopes.add(scope);
            }
        }
        return defaultScopes;
    }

    public static List<String> listScope() {
        return Arrays.stream(AuthPinterestScope.values()).map(AuthPinterestScope::getScope).collect(Collectors.toList());
    }
}