!function($){"use strict";$.extend($.fn.select2.defaults,{formatNoMatches:function(){return"No se encontraron resultados"},formatInputTooShort:function(input,min){var n=min-input.length;return"Por favor, introduzca "+n+" car"+(1==n?"ácter":"acteres")},formatInputTooLong:function(input,max){var n=input.length-max;return"Por favor, elimine "+n+" car"+(1==n?"ácter":"acteres")},formatSelectionTooBig:function(limit){return"Sólo puede seleccionar "+limit+" elemento"+(1==limit?"":"s")},formatLoadMore:function(){return"Cargando más resultados…"},formatSearching:function(){return"Buscando…"}})}(jQuery);