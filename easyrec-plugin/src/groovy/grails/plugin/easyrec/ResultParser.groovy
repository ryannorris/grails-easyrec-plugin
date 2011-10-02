package grails.plugin.easyrec

import groovy.util.slurpersupport.GPathResult

/**
 * TODO
 *
 * @since 21.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class ResultParser {

    EasyrecRecommendResponse fromXml(GPathResult xml) {
        EasyrecRecommendResponse result = new EasyrecRecommendResponse()
        result.tenantId = xml.tenantid.text()
        result.action = xml.action.text()
        result.userId = xml.user.text()
        result.recommended = xml.recommendeditems.item.collect {
            new EasyrecItem(
                    id: it.id.text(),
                    type: it.type.text(),
                    description: it.description.text().trim(),
                    url: it.url.text().trim(),
                    imageUrl: it.imageurl?.text()?.trim() ?: null,
            )
        }
        return result
    }

}
