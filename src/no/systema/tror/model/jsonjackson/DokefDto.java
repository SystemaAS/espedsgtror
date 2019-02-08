package no.systema.tror.model.jsonjackson;

import java.math. BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * Dto for Fly Fraktbrev (common for Import and Export)
 * 
 * @author Oscar de la Torre
 * @date Feb, 2019
 */
@Data
public class DokefDto {

	 private String dfst;       //status                                   1    1     1         a
	 private String dfxx1;      //ledige 55 lang                           2   55    54         a
	 private String dftlfs;     //telefonnummer 15                        56   70    15         a
	 private String dftlfk;     //telefonnummer 15                        71   85    15         a
	 private String dfkddc;     //due carrier kode                        86   86     1         a
	 private String dfbldc; //due carrier beløp                       87   95     9   9   2 s
	 private String dfinf1;     //informasjon-1                           96  130    35         a
	 private String dfinf2;     //informasjon-2                          131  165    35         a
	 private String dfvs7;      //vareslag                               166  190    25         a
	 private String dfvs8;      //vareslag                               191  215    25         a
	 private String dfvs9;      //vareslag                               216  240    25         a
	 private String dfvs10;     //vareslag                               241  265    25         a
	 private String dfxx2;      //ledige 22 lang                         266  287    22         a
	 private String dfft;       //dokument tekst                         288  328    41         a
	 private String dfsg;      //signatur                               329  331     3         a
	 private String  dffsn ;      //flyselskapsnr.                         332  334     3   3   0 s
	 private String dfroa1;     //routing a                              335  337     3         a
	 private String dfrob1;     //routing b                              338  344     7         a
	 private String  dfroc1 ;     //routing c                              345  346     2   2   0 s
	 private String dfroa2;     //routing a                              347  349     3         a
	 private String dfrob2;     //routing b                              350  356     7         a
	 private String  dfroc2 ;     //routing c                              357  358     2   2   0 s
	 private String dfroa3;     //routing a                              359  361     3         a
	 private String dfrob3;     //routing b                              362  368     7         a
	 private String  dfroc3 ;     //routing c                              369  370     2   2   0 s
	 private String dfval;      //valutakode                             371  373     3         a
	 private String dfccpp;     //ccpp pâ fraktbrev                      374  375     2         a
	 private String dfdvca;     //decl. value carriage                   376  382     7         a
	 private String dfdvcu;     //decl. value customs                    383  389     7         a
	 private String dfbelf;     //forikring belÿp                        390  396     7   7   0 s
	 private String dfinfa;     //fritekst                               397  467    71         a
	 private String dfinfb;     //fritekst                               468  538    71         a
	 private String dfinfc;     //fritekst                               539  609    71         a
	 private String dfnt1;     //antall                                 610  613     4         a
	 private String dfvkt1;     //vekt-1                                 614  617     4   7   1 p
	 private String dfrc1;      //rate class                             618  618     1         a
	 private String dfcom1;     //commdity                               619  622     4         a
	 private String dffbv1;    //fraktbr.vekt-1                         623  626     4   7   1 p
	 private String dfrk1;      //rate kode                              627  627     1         a
	 private String dfrpr1;     //bel¯p                                  628  635     8   8   2 s
	 private String dfblt1;     //bel¯p                                  636  645    10  10   2 s
	 private String dfvs1;      //vareslag                               646  670    25         a
	 private String dfnt2;      //antall                                 671  674     4         a
	 private String dfvkt2;     //vekt-2                                 675  678     4   7   1 p
	 private String dfrc2;      //rate class                             679  679     1         a
	 private String dfcom2;     //commdity                               680  683     4         a
	 private String dffbv2;     //fraktbr.vekt-2                         684  687     4   7   1 p
	 private String dfrk2;      //rate kode                              688  688     1         a
	 private String dfrpr2;     //bel¯p                                  689  696     8   8   2 s
	 private String dfblt2;    //bel¯p                                  697  706    10  10   2 s
	 private String dfvs2;      //vareslag                               707  731    25         a
	 private String dfnt3;      //antall                                 732  735     4         a
	 private String dfvkt3;     //vekt-3                                 736  739     4   7   1 p
	 
	 private String dfrc3;      //rate class                             740  740     1         a
	 private String dfcom3;     //commdity                               741  744     4         a
	 private String dffbv3;     //fraktbr.vekt-3                         745  748     4   7   1 p
	 private String dfrk3;      //rate kode                              749  749     1         a
	 private String dfrpr3;     //bel¯p                                  750  757     8   8   2 s
	 private String dfblt3;    //bel¯p                                  758  767    10  10   2 s
	 private String dfvs3;      //vareslag                               768  792    25         a
	 private String dfnt4;      //antall                                 793  796     4         a
	 private String dfvkt4;    //vekt-4                                 797  800     4   7   1 p
	 private String dfrc4;      //rate class                             801  801     1         a
	 private String dfcom4;     //commdity                               802  805     4         a
	 private String dffbv4;    //fraktbr.vekt-4                         806  809     4   7   1 p
	 private String dfrk4;      //rate kode                              810  810     1         a
	 private String dfrpr4;    //bel¯p                                  811  818     8   8   2 s
	 private String dfblt4;   //bel¯p                                  819  828    10  10   2 s
	 private String dfvs4;      //vareslag                               829  853    25         a
	 private String dfnt5;      //antall                                 854  857     4         a
	 private String dfvkt5;   //vekt-5                                 858  861     4   7   1 p
	 private String dfrc5;      //rate class                             862  862     1         a
	 private String dfcom5;     //commdity                               863  866     4         a
	 private String dffbv5;    //fraktbr.vekt-5                         867  870     4   7   1 p
	 private String dfrk5;      //rate kode                              871  871     1         a
	 private String dfrpr5;    //bel¯p                                  872  879     8   8   2 s
	 private String dfblt5;  //bel¯p                                  880  889    10  10   2 s
	 private String dfvs5;      //vareslag                               890  914    25         a
	 private String dfnt6;      //antall                                 915  918     4         a
	 private String dfvkt6;    //vekt-6                                 919  922     4   7   1 p
	 private String dfrc6 ;     //rate class                             923  923     1         a
	 private String dfcom6;     //commdity                               924  927     4         a
	 private String dffbv6;    //fraktbr.vekt-6                         928  931     4   7   1 p
	 private String dfrk6;      //rate kode                              932  932     1         a
	 private String dfrpr6;    //bel¯p                                  933  940     8   8   2 s
	 private String dfblt6 ;     //bel¯p                                  941  950    10  10   2 s
	 private String dfvs6;      //kundenr selger                         951  975    25         a
	 private String dfntt ;      //antall                                 976  979     4   4   0 s
	 private String dfblt ;      //bel¯p                                  980  984     5   9   2 p
	 private String dfvktt ;     //totall vekt                            985  988     4   7   1 p
	 private String dfbla ;      //bel¯p                                  989  993     5   9   2 p
	 private String dfblav ;     //avgift belÿp                           994  998     5   9   2 p
	 private String dfkdme;     //merkelapp  /x                          999  999     1         a
	 private String dfxx3;      //ledige                                1000 1006     7         a
	 private String dfri;       //record id                             1007 1007     1         a
	 private String  dfavd  ;     //avdeling                              1008 1011     4   4   0 s
	 private String  dfopd  ;    //oppdragsnummer                        1012 1018     7   7   0 s
	 private String  dflop  ;    //lopenr                                1019 1021     3   3   0 s
	 private String dfcmn;      //comunication                          1022 1022     1         a
	 private String  dftrid ;     //cmn. trans id                         1023 1027     5   9   0 p
	 private String dftols;     //tollstatus                            1028 1029     2         a
	 private String  dfetd1  ;     //est tim dep-1                         1030 1033     4   4   0 s
	 private String  dfeta1  ;     //est tim arr-1                         1034 1037     4   4   0 s
	 private String  dfeda1  ;     //est day arr-1                         1038 1039     2   2   0 s
	 private String  dfetd2  ;     //est tim dep-2                         1040 1043     4   4   0 s
	 private String  dfeta2  ;     //est tim arr-2                         1044 1047     4   4   0 s
	 private String  dfeda2  ;     //est day arr-2                         1048 1049     2   2   0 s
	 private String  dfetd3  ;     //est tim dep-3                         1050 1053     4   4   0 s
	 private String  dfeta3  ;     //est tim arr-3                         1054 1057     4   4   0 s
	 private String  dfeda3  ;     //est day arr-3                         1058 1059     2   2   0 s
	 private String dffue;    //fuel surcharge                        1060 1068     9   9   2 s
	 private String dfnett;     //netto frakt                           1069 1077     9   9   2 s
	 private String dfsph1;     //sph code-1                            1078 1080     3         a
	 private String dfsph2;    //sph code-2                            1081 1083     3         a
	 private String dfsph3;     //sph code-3                            1084 1086     3         a
	 private String dfsph4;     //sph code-4                            1087 1089     3         a
	 private String dfsph5;     //sph code-5                            1090 1092     3         a
	 private String dfsph6;     //sph code-6                            1093 1095     3         a
	 private String dfsph7;     //sph code-7                            1096 1098     3         a
	 private String dfsph8;     //sph code-8                            1099 1101     3         a
	 private String dfsph9;     //sph code-9                            1102 1104     3         a
	 
	 
}
