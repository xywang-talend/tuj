<?xml version="1.0" encoding="ASCII"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <head>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="POs/PO">
    	<p/>
    	<b>PO Number: <xsl:apply-templates select="Number"/></b>
		<table>
			<tr><td>Company:</td><td><xsl:apply-templates select="Company"/></td></tr>
			<tr><td>Address:</td><td><xsl:apply-templates select="Address/Street1"/></td></tr>
			<tr><td></td><td><xsl:apply-templates select="Address/Street2"/></td></tr>
			<tr><td></td><td><xsl:apply-templates select="Address/City"/>, <xsl:apply-templates select="Address/State"/><xsl:apply-templates select="Address/Postal"/></td></tr>
		</table>
	</xsl:template>
    
</xsl:stylesheet>