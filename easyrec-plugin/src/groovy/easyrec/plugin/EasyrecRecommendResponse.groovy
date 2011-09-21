package easyrec.plugin


/**
 * TODO
 *
 * @since 21.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class EasyrecRecommendResponse {

    String tenantId
    String action
    String userId
    List<EasyrecItem> recommended


    public String toString ( ) {
        return "EasyrecRecommendResponse{" +
        "userId='" + userId + '\'' +
        ", recommended=" + recommended.size() +
        " items, action='" + action + '\'' +
        ", tenantId='" + tenantId + '\'' +
        '}' ;
    }

}
