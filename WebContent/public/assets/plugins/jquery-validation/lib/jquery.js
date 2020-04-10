/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
(function() {

var parts = document.location.search.slice( 1 ).split( "&" ),
	length = parts.length,
	scripts = document.getElementsByTagName("script"),
	src = scripts[ scripts.length - 1].src,
	i = 0,
	current,
	version = "1.9.0",
	file = "http://code.jquery.com/jquery-git.js";

for ( ; i < length; i++ ) {
	current = parts[ i ].split( "=" );
	if ( current[ 0 ] === "jquery" ) {
		version = current[ 1 ];
		break;
	}
}

if (version != "git") {
	file = src.replace(/jquery\.js$/, "jquery-" + version + ".js");
}


document.write( "<script src='" + file + "'></script>" );

})();
