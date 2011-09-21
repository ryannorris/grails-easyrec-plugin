package easyrec.plugin

import grails.test.GrailsUnitTestCase

/**
 * TODO
 *
 * @since 21.09.11
 * @author Igor Artamonov (http://igorartamonov.com)
 */
class ResultParserTests extends GrailsUnitTestCase {

    ResultParser parser = new ResultParser()
    XmlSlurper slurper = new XmlSlurper()

    void testParseRecommendationsForUser() {
        String rawXml = '''
            <?xml version="1.0" encoding="ISO-8859-1"?>
            <easyrec>
              <tenantid>EASYREC_DEMO</tenantid>
              <action>recommendationsForUser</action>
              <user>
                 <id>24EH1723322222A3</id>
              </user>
              <recommendeditems>
                 <item>
                    <id>43</id>
                    <type>ITEM</type>
                    <description>Beastie Boys - Intergalactic</description>
                    <url>
                      /item/beastieboys
                    </url>
                    <imageurl/>
                 </item>
              </recommendeditems>
            </easyrec>
            '''.trim()

        def xml = slurper.parse(new StringReader(rawXml))

        EasyrecRecommendResponse response = parser.fromXml(xml)
        assertEquals('EASYREC_DEMO', response.tenantId)
        assertEquals('recommendationsForUser', response.action)
        assertEquals('24EH1723322222A3', response.userId)
        assertEquals('Count of recommendations', 1, response.recommended.size())
        EasyrecItem exp = new EasyrecItem(
                id: '43',
                type: 'ITEM',
                description: 'Beastie Boys - Intergalactic',
                url: '/item/beastieboys'
        )
        assertEquals(exp, response.recommended[0])
    }
}
