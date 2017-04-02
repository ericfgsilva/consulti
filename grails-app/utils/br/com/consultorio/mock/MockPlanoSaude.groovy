package br.com.consultorio.mock

import grails.transaction.Transactional
import br.com.consultorio.PlanoSaude;
import br.com.consultorio.mock.impl.RegisterMockImpl
import br.com.consultorio.security.Role
import br.com.consultorio.security.User
import br.com.consultorio.security.UserRole

class MockPlanoSaude implements RegisterMockImpl {

	def mock() {
		if(PlanoSaude.count() == 0) {
			new PlanoSaude(nome: "Semper Cursus Integer Limited", descricao: "non, hendrerit id, ante.", registroANS: "5368047270895919", contato: "facilisis@lobortistellus.ca").save flush:true
			new PlanoSaude(nome: "Imperdiet Inc.", descricao: "vel, venenatis vel,", registroANS: "5172791938674638", contato: "nunc@feugiat.org").save flush:true
			new PlanoSaude(nome: "Non LLC", descricao: "Cras pellentesque. Sed dictum.", registroANS: "348568387576379", contato: "semper.Nam.tempor@tincidunt.com").save flush:true
			new PlanoSaude(nome: "Et Eros Foundation", descricao: "orci. Ut semper pretium neque. Morbi quis urna. Nunc quis", registroANS: "4403463814500719", contato: "Ut.sagittis.lobortis@Loremipsum.co.uk").save flush:true
			new PlanoSaude(nome: "Cursus Luctus Ipsum Institute", descricao: "vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae", registroANS: "5189721556664448", contato: "eu@malesuada.co.uk").save flush:true
			new PlanoSaude(nome: "Dui Company", descricao: "tempor diam dictum sapien.", registroANS: "5386197150405497", contato: "non.enim@tristiquepellentesquetellus.org").save flush:true
			new PlanoSaude(nome: "Tellus Justo LLP", descricao: "sit amet, consectetuer adipiscing elit. Etiam laoreet,", registroANS: "374170635408256", contato: "pretium.et@sapiengravida.edu").save flush:true
			new PlanoSaude(nome: "Ante Dictum Company", descricao: "nulla ante, iaculis nec, eleifend non, dapibus rutrum, justo.", registroANS: "347805205686944", contato: "pellentesque.eget@metus.com").save flush:true
			new PlanoSaude(nome: "Phasellus Associates", descricao: "varius et, euismod et, commodo", registroANS: "349867128428073", contato: "Sed@dolor.ca").save flush:true
			new PlanoSaude(nome: "Ultrices Mauris Ipsum Inc.", descricao: "arcu imperdiet ullamcorper. Duis at lacus. Quisque", registroANS: "5446571115632540", contato: "sollicitudin@vitae.co.uk").save flush:true
			new PlanoSaude(nome: "Dis Parturient Montes LLP", descricao: "vulputate, nisi sem semper", registroANS: "4577728469343850", contato: "Mauris.magna@sollicitudinorci.edu").save flush:true
			new PlanoSaude(nome: "Aliquet Diam Associates", descricao: "vitae purus gravida sagittis.", registroANS: "5493513743481595", contato: "ac.mattis@dictummi.ca").save flush:true
			new PlanoSaude(nome: "Accumsan Neque Incorporated", descricao: "purus mauris a nunc. In at pede.", registroANS: "344721303572418", contato: "felis.ullamcorper@orciinconsequat.edu").save flush:true
			new PlanoSaude(nome: "Semper Erat LLC", descricao: "sagittis semper. Nam tempor diam dictum sapien.", registroANS: "5159649401372291", contato: "Phasellus.at@vel.com").save flush:true
			new PlanoSaude(nome: "Vulputate Risus LLC", descricao: "nunc sed libero. Proin sed turpis nec", registroANS: "5165007304442111", contato: "sit.amet.consectetuer@inconsequat.ca").save flush:true
			new PlanoSaude(nome: "Luctus LLC", descricao: "In scelerisque scelerisque dui. Suspendisse", registroANS: "4237967745168135", contato: "arcu.ac@loremauctor.net").save flush:true
			new PlanoSaude(nome: "Tempus Lorem Fringilla LLC", descricao: "sit amet ultricies sem magna nec", registroANS: "5129481444070119", contato: "tortor@neque.edu").save flush:true
			new PlanoSaude(nome: "Nunc Corporation", descricao: "Curae; Phasellus ornare.", registroANS: "4660460752528165", contato: "Donec.nibh@aliquetvelvulputate.net").save flush:true
			new PlanoSaude(nome: "Morbi Accumsan LLP", descricao: "posuere at, velit. Cras lorem", registroANS: "5380888339723461", contato: "Sed.diam.lorem@vehicula.co.uk").save flush:true
			new PlanoSaude(nome: "Lacus Nulla LLC", descricao: "fringilla est. Mauris", registroANS: "5152048794380380", contato: "ac@quis.net").save flush:true
			new PlanoSaude(nome: "Quis Massa Mauris Incorporated", descricao: "tristique senectus et netus et", registroANS: "5115425788816066", contato: "gravida@Integerurna.edu").save flush:true
			new PlanoSaude(nome: "Parturient Limited", descricao: "Fusce mollis. Duis sit amet diam eu dolor", registroANS: "4711694051884116", contato: "dolor.Fusce@temporest.co.uk").save flush:true
			new PlanoSaude(nome: "Amet Risus Donec Ltd", descricao: "vitae mauris sit amet lorem", registroANS: "343461411370897", contato: "metus@consectetueradipiscing.edu").save flush:true
			new PlanoSaude(nome: "Hendrerit Id LLC", descricao: "semper pretium neque. Morbi quis", registroANS: "347873282800424", contato: "posuere.at@Sed.com").save flush:true
			new PlanoSaude(nome: "Eget Laoreet Posuere Consulting", descricao: "pede. Nunc sed orci lobortis augue scelerisque mollis. Phasellus libero", registroANS: "5145434048441232", contato: "vitae@lacinia.com").save flush:true
			new PlanoSaude(nome: "Nisi Nibh Lacinia Industries", descricao: "luctus, ipsum leo elementum sem, vitae aliquam", registroANS: "5198709831144661", contato: "turpis@Donec.ca").save flush:true
			new PlanoSaude(nome: "Faucibus Ut Incorporated", descricao: "ultrices iaculis odio. Nam interdum enim", registroANS: "4202095251483844", contato: "malesuada.fames.ac@molestiepharetra.org").save flush:true
			new PlanoSaude(nome: "Malesuada Corporation", descricao: "quam. Curabitur vel lectus. Cum", registroANS: "374147497608799", contato: "lobortis@imperdiet.edu").save flush:true
			new PlanoSaude(nome: "Arcu Corp.", descricao: "dolor egestas rhoncus. Proin nisl", registroANS: "376611950131134", contato: "mauris.eu.elit@ipsumdolor.com").save flush:true
			new PlanoSaude(nome: "Natoque Corporation", descricao: "et libero. Proin mi. Aliquam gravida mauris ut mi.", registroANS: "349630264507140", contato: "Phasellus.at.augue@tellussem.edu").save flush:true
			new PlanoSaude(nome: "Id Enim Curabitur Corporation", descricao: "volutpat nunc sit amet", registroANS: "4552502122148874", contato: "Nunc@metusAeneansed.org").save flush:true
			new PlanoSaude(nome: "Enim Sit Corp.", descricao: "et ultrices posuere cubilia Curae; Phasellus ornare. Fusce mollis.", registroANS: "5134166772207246", contato: "malesuada.ut.sem@felis.co.uk").save flush:true
			new PlanoSaude(nome: "Sit Amet Limited", descricao: "dignissim tempor arcu. Vestibulum ut eros non", registroANS: "5469094583787957", contato: "dolor.sit.amet@magna.org").save flush:true
			new PlanoSaude(nome: "Tellus Incorporated", descricao: "dolor. Quisque tincidunt", registroANS: "5340934087978670", contato: "Pellentesque.habitant.morbi@dolortempusnon.co.uk").save flush:true
			new PlanoSaude(nome: "Risus Quisque Company", descricao: "blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae", registroANS: "4645131536573171", contato: "odio.Phasellus.at@acurnaUt.ca").save flush:true
			new PlanoSaude(nome: "Vestibulum Consulting", descricao: "Aliquam tincidunt, nunc ac mattis", registroANS: "375881614045235", contato: "Donec@nec.org").save flush:true
			new PlanoSaude(nome: "At Sem Molestie Corporation", descricao: "ante dictum cursus. Nunc mauris elit, dictum eu, eleifend nec,", registroANS: "5127131238384174", contato: "erat@fermentum.org").save flush:true
			new PlanoSaude(nome: "Lacus Quisque Imperdiet PC", descricao: "Nunc lectus pede, ultrices a, auctor non, feugiat", registroANS: "5396219507739875", contato: "tellus.eu.augue@sedturpisnec.org").save flush:true
			new PlanoSaude(nome: "Nibh Dolor Nonummy Limited", descricao: "Aliquam auctor, velit eget laoreet posuere, enim nisl elementum", registroANS: "373686819732184", contato: "ante.ipsum@erat.ca").save flush:true
			new PlanoSaude(nome: "Vitae Semper Egestas Consulting", descricao: "at risus. Nunc ac sem ut", registroANS: "5125802522706797", contato: "Donec.consectetuer@gravidamaurisut.co.uk").save flush:true
			new PlanoSaude(nome: "Risus Corp.", descricao: "enim, sit amet ornare lectus justo eu arcu. Morbi", registroANS: "5142790623372424", contato: "neque@Fuscediam.co.uk").save flush:true
			new PlanoSaude(nome: "Sed Pede Associates", descricao: "non lorem vitae odio sagittis semper.", registroANS: "378464104425624", contato: "Duis.mi.enim@aliquet.co.uk").save flush:true
			new PlanoSaude(nome: "Dignissim Consulting", descricao: "ipsum primis in faucibus orci luctus", registroANS: "5119316266188393", contato: "Proin.dolor@odio.edu").save flush:true
			new PlanoSaude(nome: "Metus Aenean Company", descricao: "parturient montes, nascetur ridiculus mus. Aenean eget magna. Suspendisse", registroANS: "5180003659096546", contato: "sem.consequat.nec@etnuncQuisque.ca").save flush:true
			new PlanoSaude(nome: "Sagittis Company", descricao: "et magnis dis parturient montes,", registroANS: "5144290445628576", contato: "faucibus.leo.in@etmagnis.com").save flush:true
			new PlanoSaude(nome: "Adipiscing Limited", descricao: "pede. Praesent eu dui. Cum sociis", registroANS: "347432357063057", contato: "justo.Proin@Donecest.net").save flush:true
			new PlanoSaude(nome: "Ipsum Phasellus Industries", descricao: "a, enim. Suspendisse aliquet, sem ut cursus luctus, ipsum leo", registroANS: "379380043361335", contato: "dis.parturient.montes@massalobortis.co.uk").save flush:true
			new PlanoSaude(nome: "Purus Ltd", descricao: "ridiculus mus. Proin vel nisl. Quisque fringilla", registroANS: "4637718896986914", contato: "tempor.augue.ac@dolor.co.uk").save flush:true
			new PlanoSaude(nome: "Rhoncus Id Mollis Corp.", descricao: "aliquet. Proin velit. Sed malesuada augue", registroANS: "5140369645883328", contato: "non.lorem@ultricesDuis.edu").save flush:true
			new PlanoSaude(nome: "Euismod Est Arcu Industries", descricao: "ornare egestas ligula.", registroANS: "5174688773336828", contato: "risus.Donec.nibh@eudoloregestas.ca").save flush:true
			new PlanoSaude(nome: "Nascetur Institute", descricao: "molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam", registroANS: "341582068407908", contato: "eget@Phasellusdolorelit.edu").save flush:true
			new PlanoSaude(nome: "Quisque Varius Nam Corporation", descricao: "vel, mauris. Integer sem", registroANS: "374579543474135", contato: "nunc.ac@ascelerisque.com").save flush:true
			new PlanoSaude(nome: "Nullam Consulting", descricao: "vel, vulputate eu, odio. Phasellus at augue", registroANS: "344585817852527", contato: "blandit.mattis.Cras@etmagnis.org").save flush:true
			new PlanoSaude(nome: "Eu Tempor Erat LLP", descricao: "Aenean eget metus.", registroANS: "5340434797788030", contato: "dolor.Fusce@massaMauris.co.uk").save flush:true
			new PlanoSaude(nome: "In Aliquet LLP", descricao: "lobortis. Class aptent taciti sociosqu ad litora torquent per", registroANS: "5124528262745589", contato: "leo.elementum.sem@duilectusrutrum.co.uk").save flush:true
			new PlanoSaude(nome: "Orci Lobortis Augue Company", descricao: "commodo ipsum. Suspendisse non leo. Vivamus nibh dolor, nonummy ac,", registroANS: "5381292227008389", contato: "turpis.vitae@porttitorvulputate.net").save flush:true
			new PlanoSaude(nome: "Et Magnis Inc.", descricao: "sagittis. Duis gravida. Praesent eu nulla at sem molestie", registroANS: "5339144628974601", contato: "vulputate@nisimagnased.com").save flush:true
			new PlanoSaude(nome: "Scelerisque Mollis PC", descricao: "justo eu arcu. Morbi sit amet massa. Quisque", registroANS: "373473778789396", contato: "arcu.Sed@eutellus.org").save flush:true
			new PlanoSaude(nome: "Risus Odio Consulting", descricao: "est. Nunc laoreet lectus quis massa. Mauris vestibulum, neque sed", registroANS: "5122767203096304", contato: "volutpat.ornare.facilisis@ipsum.co.uk").save flush:true
			new PlanoSaude(nome: "Lorem Auctor Quis Corporation", descricao: "Donec felis orci, adipiscing non, luctus sit", registroANS: "4952641302859411", contato: "erat.neque.non@utpharetrased.edu").save flush:true
			new PlanoSaude(nome: "Cum Sociis Inc.", descricao: "fringilla ornare placerat, orci", registroANS: "343104043300722", contato: "Lorem.ipsum@cursusnon.org").save flush:true
			new PlanoSaude(nome: "Fringilla Porttitor Vulputate Company", descricao: "neque tellus, imperdiet non, vestibulum", registroANS: "346801741531111", contato: "tempor.augue@suscipitnonummyFusce.net").save flush:true
			new PlanoSaude(nome: "Arcu Vel Quam Company", descricao: "lorem, auctor quis, tristique", registroANS: "5329430902493180", contato: "libero.et.tristique@pharetra.edu").save flush:true
			new PlanoSaude(nome: "Mi Tempor Limited", descricao: "Vivamus molestie dapibus", registroANS: "5190135016795240", contato: "Donec.egestas@Aliquam.edu").save flush:true
			new PlanoSaude(nome: "Dolor Sit Company", descricao: "tempor bibendum. Donec felis orci, adipiscing non, luctus sit amet,", registroANS: "4989515033317728", contato: "aliquam@enimNuncut.org").save flush:true
			new PlanoSaude(nome: "Dapibus Ligula Ltd", descricao: "iaculis quis, pede. Praesent eu dui. Cum sociis", registroANS: "5383944056150504", contato: "scelerisque@QuisquevariusNam.com").save flush:true
			new PlanoSaude(nome: "Nec Mollis Vitae Company", descricao: "eu augue porttitor interdum. Sed auctor odio", registroANS: "344895115724765", contato: "Etiam.laoreet.libero@Namconsequat.net").save flush:true
			new PlanoSaude(nome: "Nunc Laoreet Inc.", descricao: "enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula", registroANS: "372608274171596", contato: "sit@nislelementumpurus.org").save flush:true
			new PlanoSaude(nome: "Sollicitudin Orci Sem LLP", descricao: "Donec tempus, lorem fringilla ornare placerat, orci", registroANS: "5380163563890382", contato: "aliquam.adipiscing.lacus@augueeu.ca").save flush:true
			new PlanoSaude(nome: "Arcu Imperdiet PC", descricao: "adipiscing ligula. Aenean", registroANS: "347581935461144", contato: "risus@sociosquad.ca").save flush:true
			new PlanoSaude(nome: "Ac Foundation", descricao: "risus, at fringilla purus mauris a nunc.", registroANS: "344188526442270", contato: "Nam@tinciduntnibhPhasellus.org").save flush:true
			new PlanoSaude(nome: "Velit Justo Incorporated", descricao: "non, luctus sit", registroANS: "5122954187262807", contato: "pellentesque.a@lorem.org").save flush:true
			new PlanoSaude(nome: "Parturient Montes Inc.", descricao: "ipsum porta elit, a feugiat tellus lorem eu metus. In", registroANS: "346046039886779", contato: "sem.mollis@Nulladignissim.com").save flush:true
			new PlanoSaude(nome: "Nisl Sem Consequat Inc.", descricao: "ridiculus mus. Aenean", registroANS: "375120153065302", contato: "mauris.aliquam@semut.edu").save flush:true
			new PlanoSaude(nome: "Molestie Associates", descricao: "Pellentesque ultricies dignissim lacus. Aliquam rutrum lorem ac risus. Morbi", registroANS: "4929578464012595", contato: "Nam@condimentum.net").save flush:true
			new PlanoSaude(nome: "Orci Sem Eget LLP", descricao: "Fusce feugiat. Lorem ipsum dolor", registroANS: "379475084453825", contato: "dictum.augue@Donecest.org").save flush:true
			new PlanoSaude(nome: "Nunc Mauris Elit Institute", descricao: "pede et risus. Quisque libero", registroANS: "5325525101283565", contato: "nibh.Phasellus.nulla@felis.org").save flush:true
			new PlanoSaude(nome: "Pellentesque Tellus Associates", descricao: "Pellentesque tincidunt tempus risus.", registroANS: "4867582800146196", contato: "consectetuer.adipiscing@eleifend.co.uk").save flush:true
			new PlanoSaude(nome: "Enim Mi Tempor Foundation", descricao: "pede, malesuada vel,", registroANS: "4585227342369036", contato: "sollicitudin.commodo@nec.co.uk").save flush:true
			new PlanoSaude(nome: "Imperdiet Consulting", descricao: "Mauris vel turpis. Aliquam", registroANS: "5155894747208803", contato: "elit@sed.edu").save flush:true
			new PlanoSaude(nome: "Ligula Associates", descricao: "ut aliquam iaculis, lacus pede sagittis augue, eu", registroANS: "5161447053393349", contato: "vitae@justofaucibus.edu").save flush:true
			new PlanoSaude(nome: "Sagittis Industries", descricao: "vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam", registroANS: "5264343418357893", contato: "ante.Vivamus.non@magnaetipsum.net").save flush:true
			new PlanoSaude(nome: "Quisque Imperdiet Industries", descricao: "fermentum metus. Aenean sed pede nec ante blandit viverra.", registroANS: "349169018195011", contato: "magna.Sed@vitae.ca").save flush:true
			new PlanoSaude(nome: "Mus Associates", descricao: "justo. Praesent luctus.", registroANS: "5197305231918583", contato: "Quisque.tincidunt.pede@Nullamfeugiat.org").save flush:true
			new PlanoSaude(nome: "Eu Odio LLP", descricao: "Pellentesque habitant morbi tristique senectus et", registroANS: "5394778216145938", contato: "Fusce.dolor.quam@nonlacinia.org").save flush:true
			new PlanoSaude(nome: "Ligula Aliquam Consulting", descricao: "cursus luctus, ipsum leo", registroANS: "5116218444695696", contato: "erat@nislNullaeu.org").save flush:true
			new PlanoSaude(nome: "Donec Tempor Est Foundation", descricao: "Proin velit. Sed malesuada augue ut lacus. Nulla tincidunt,", registroANS: "347859745892694", contato: "dignissim.magna@non.com").save flush:true
			new PlanoSaude(nome: "Cras Vehicula Industries", descricao: "mi. Duis risus odio, auctor", registroANS: "373392284512050", contato: "risus.a.ultricies@tellusnon.ca").save flush:true
			new PlanoSaude(nome: "Luctus Curabitur Egestas Company", descricao: "Nunc mauris sapien, cursus in, hendrerit consectetuer, cursus et, magna.", registroANS: "5140956232589664", contato: "sapien.cursus.in@utodio.ca").save flush:true
			new PlanoSaude(nome: "Ac Orci PC", descricao: "elit, a feugiat", registroANS: "5191364662065176", contato: "purus.sapien@MaurismagnaDuis.edu").save flush:true
			new PlanoSaude(nome: "Erat Volutpat Nulla Limited", descricao: "Sed et libero. Proin mi. Aliquam gravida mauris ut", registroANS: "5329186975406481", contato: "consectetuer.euismod@vitaepurusgravida.edu").save flush:true
			new PlanoSaude(nome: "Libero Dui Nec Company", descricao: "per conubia nostra, per inceptos", registroANS: "346199666559692", contato: "dui.augue@Aenean.net").save flush:true
			new PlanoSaude(nome: "Fermentum Consulting", descricao: "posuere at, velit. Cras lorem lorem, luctus", registroANS: "5159382077376352", contato: "nulla.vulputate.dui@tinciduntvehicula.edu").save flush:true
			new PlanoSaude(nome: "Vel Arcu Curabitur Company", descricao: "ullamcorper. Duis cursus, diam", registroANS: "4486178778996697", contato: "ultrices.Vivamus@porttitorscelerisqueneque.ca").save flush:true
			new PlanoSaude(nome: "Et Libero Associates", descricao: "Sed eget lacus. Mauris non dui nec", registroANS: "5352131682392200", contato: "vestibulum.Mauris.magna@cursus.edu").save flush:true
			new PlanoSaude(nome: "Velit Company", descricao: "tristique neque venenatis lacus. Etiam bibendum fermentum metus.", registroANS: "345833358070811", contato: "tempus.mauris.erat@montes.co.uk").save flush:true
			new PlanoSaude(nome: "Scelerisque Neque Nullam Associates", descricao: "aliquet. Phasellus fermentum convallis", registroANS: "343256193405010", contato: "libero@ornaretortor.org").save flush:true
			new PlanoSaude(nome: "Quam Dignissim PC", descricao: "id, blandit at, nisi.", registroANS: "5491082839681763", contato: "ac.mattis.semper@orci.ca").save flush:true
			new PlanoSaude(nome: "Rhoncus Nullam Velit LLP", descricao: "ultrices iaculis odio. Nam interdum enim non", registroANS: "347441632246591", contato: "diam@neccursus.co.uk").save flush:true
			new PlanoSaude(nome: "Pharetra Nibh Incorporated", descricao: "Duis sit amet diam eu dolor", registroANS: "5112725497940553", contato: "lorem.eget.mollis@nisisem.edu").save flush:true
		}
	}
}
