package com.andreisingeleytsev.playingquizapp.data.game.model

import com.andreisingeleytsev.playingquizapp.R

sealed class QuizItem(val name: Int, val list: List<QuestionItem>) {
    data object HistoryQuizItem : QuizItem(
        R.string.historical_figures,
        listOf(
            QuestionItem(
                R.string.question1,
                listOf(
                    R.string.george_washington,
                    R.string.thomas_jefferson,
                    R.string.benjamin_franklin,
                    R.string.john_adams
                )
            ),
            QuestionItem(
                R.string.question2,
                listOf(
                    R.string.christopher_columbus,
                    R.string.ferdinand_magellan,
                    R.string.vasco_da_gama,
                    R.string.marco_polo
                )
            ),
            QuestionItem(
                R.string.question3,
                listOf(
                    R.string.johannes_gutenberg,
                    R.string.leonardo_da_vinci,
                    R.string.galileo_galilei,
                    R.string.isaac_newton
                )
            ),
            QuestionItem(
                R.string.question4,
                listOf(
                    R.string.julius_caesar,
                    R.string.augustus,
                    R.string.napoleon_bonaparte,
                    R.string.alexander_the_great
                )
            ),
            QuestionItem(
                R.string.question5,
                listOf(
                    R.string.vladimir_lenin,
                    R.string.joseph_stalin,
                    R.string.leon_trotsky,
                    R.string.mikhail_gorbachev
                )
            ),

            QuestionItem(
                R.string.question6,
                listOf(
                    R.string.martin_luther_king_jr,
                    R.string.malcolm_x,
                    R.string.nelson_mandela,
                    R.string.rosa_parks
                )
            ),

            QuestionItem(
                R.string.question7,
                listOf(
                    R.string.cleopatra,
                    R.string.nefertiti,
                    R.string.hatshepsut, R.string.isis
                )
            ),

            QuestionItem(
                R.string.question8,
                listOf(
                    R.string.albert_einstein,
                    R.string.niels_bohr, R.string.isaac_newton, R.string.galileo_galilei
                )
            ),

            QuestionItem(
                R.string.question10,
                listOf(
                    R.string.abraham_lincoln,
                    R.string.andrew_johnson,
                    R.string.ulysses_s_grant, R.string.thomas_jefferson
                )
            ),

            QuestionItem(
                R.string.question9,
                listOf(
                    R.string.amelia_earhart,
                    R.string.bessie_coleman,
                    R.string.harriet_quimby,
                    R.string.jacqueline_cochran
                )
            ),

            QuestionItem(
                R.string.question11,
                listOf(
                    R.string.florence_nightingale,
                    R.string.clara_barton,
                    R.string.mary_seacole,
                    R.string.edith_cavell
                )
            ),

            QuestionItem(
                R.string.question12,
                listOf(
                    R.string.toussaint_louverture,
                    R.string.jean_jacques_dessalines,
                    R.string.henri_christophe,
                    R.string.fran_ois_dominique_toussaint_louverture
                )
            ),

            QuestionItem(
                R.string.question13,
                listOf(
                    R.string.charles_darwin,
                    R.string.alfred_russel_wallace,
                    R.string.gregor_mendel,
                    R.string.thomas_huxley
                )
            ),

            QuestionItem(
                R.string.question14,
                listOf(
                    R.string.confucius,
                    R.string.laozi, R.string.mencius,

                    R.string.xunzi
                )
            ),

            QuestionItem(
                R.string.question15,
                listOf(
                    R.string.marie_curie,
                    R.string.rosalind_franklin,
                    R.string.dorothy_crowfoot_hodgkin,
                    R.string.rita_levi_montalcini
                )
            ),

            QuestionItem(
                R.string.question16,
                listOf(
                    R.string.ludwig_van_beethoven,
                    R.string.wolfgang_amadeus_mozart,
                    R.string.johann_sebastian_bach,
                    R.string.pyotr_ilyich_tchaikovsky
                )
            ),

            QuestionItem(
                R.string.question17,
                listOf(
                    R.string.malcolm_x, R.string.martin_luther_king_jr,
                    R.string.eldridge_cleaver,
                    R.string.huey_p_newton
                )
            ),
            QuestionItem(
                R.string.question18,
                listOf(
                    R.string.martin_luther_king_jr,
                    R.string.malcolm_x,
                    R.string.nelson_mandela,
                    R.string.rosa_parks
                )
            ),
            QuestionItem(
                R.string.question19,
                listOf(
                    R.string.socrates,
                    R.string.plato,
                    R.string.aristotle, R.string.epicurus
                )
            ),
            QuestionItem(
                R.string.question20,
                listOf(
                    R.string.amelia_earhart,
                    R.string.bessie_coleman,
                    R.string.harriet_quimby,
                    R.string.jacqueline_cochran
                )
            )
        )
    )

    data object GeographyQuizItem : QuizItem(
        name = R.string.the_geography_of_the_world,
        list = listOf(
            QuestionItem(
                R.string.question21,
                listOf(
                    R.string.paris,
                    R.string.berlin, R.string.madrid,

                    R.string.rome
                )
            ),
            QuestionItem(
                R.string.question22,
                listOf(
                    R.string.nile,
                    R.string.amazon,
                    R.string.mississippi, R.string.yangtze
                )
            ),
            QuestionItem(
                R.string.question23,
                listOf(
                    R.string.rocky_mountains, R.string.alps,
                    R.string.andes, R.string.himalayas
                )
            ),


            QuestionItem(
                R.string.question24,
                listOf(
                    R.string.brazil, R.string.argentina,
                    R.string.peru, R.string.colombia
                )
            ),

            QuestionItem(
                R.string.question25,
                listOf(
                    R.string.south_africa, R.string.kenya,
                    R.string.nigeria, R.string.egypt
                )
            ),

            QuestionItem(
                R.string.question26,
                listOf(
                    R.string.nile, R.string.congo,
                    R.string.niger, R.string.zambezi
                )
            ),

            QuestionItem(
                R.string.question27,
                listOf(
                    R.string.venice, R.string.amsterdam,
                    R.string.bruges, R.string.copenhagen
                )
            ),

            QuestionItem(
                R.string.question28,
                listOf(
                    R.string.antarctica,
                    R.string.sahara,
                    R.string.arabian_desert,
                    R.string.gobi_desert
                )
            ),

            QuestionItem(
                R.string.question29,
                listOf(
                    R.string.japan,
                    R.string.china,
                    R.string.south_korea,
                    R.string.vietnam
                )
            ),

            QuestionItem(
                R.string.question30,
                listOf(
                    R.string.canberra,
                    R.string.sydney,
                    R.string.melbourne,
                    R.string.brisbane
                )
            ),

            QuestionItem(
                R.string.question31,
                listOf(
                    R.string.the_alps,
                    R.string.the_pyrenees,
                    R.string.the_carpathians,
                    R.string.the_apennines
                )
            ),

            QuestionItem(
                R.string.question32,
                listOf(
                    R.string.australia,
                    R.string.new_zealand,
                    R.string.madagascar,
                    R.string.greenland
                )
            ),

            QuestionItem(
                R.string.question33,
                listOf(
                    R.string.sicily,
                    R.string.sardinia,
                    R.string.cyprus,
                    R.string.crete
                )
            ),

            QuestionItem(
                R.string.question34,
                listOf(
                    R.string.nile,
                    R.string.tigris,
                    R.string.euphrates,
                    R.string.jordan
                )
            ),

            QuestionItem(
                R.string.question35,
                listOf(
                    R.string.florida,
                    R.string.california,
                    R.string.texas,
                    R.string.arizona
                )
            ),

            QuestionItem(
                R.string.question36,
                listOf(
                    R.string.algeria,
                    R.string.niger,
                    R.string.south_africa,
                    R.string.sudan
                )
            ),

            QuestionItem(
                R.string.question37,
                listOf(
                    R.string.bering_strait,
                    R.string.strait_of_gibraltar,
                    R.string.strait_of_hormuz,
                    R.string.strait_of_malacca
                )
            ),
            QuestionItem(
                R.string.question38,
                listOf(
                    R.string.norway,
                    R.string.canada,
                    R.string.sweden,
                    R.string.finland
                )
            ),
            QuestionItem(
                R.string.question39,
                listOf(
                    R.string.mount_everest,
                    R.string.k2,
                    R.string.malu,
                    R.string.lhotse
                )
            ),
            QuestionItem(
                R.string.question40,
                listOf(
                    R.string.tigris,
                    R.string.euphrates,
                    R.string.nile,
                    R.string.indus
                )
            )
        )
    )

    data object CinemaQuizItem :
        QuizItem(
            R.string.cinema_and_tv,
            listOf(
                QuestionItem(
                    R.string.question41,
                    listOf(
                        R.string.robert_downey_jr,
                        R.string.chris_evans,
                        R.string.chris_hemsworth,
                        R.string.mark_ruffalo
                    )
                ),
                QuestionItem(
                    R.string.question41,
                    listOf(
                        R.string.robert_downey_jr,
                        R.string.chris_evans,
                        R.string.chris_hemsworth,
                        R.string.mark_ruffalo
                    )
                ),

                QuestionItem(
                    R.string.question43,
                    listOf(
                        R.string.leonardo_dicaprio,
                        R.string.brad_pitt,
                        R.string.tom_cruise,
                        R.string.matthew_mcconaughey
                    )
                ),

                QuestionItem(
                    R.string.question44,
                    listOf(
                        R.string.casablanca,
                        R.string.gone_with_the_wind,
                        R.string.the_godfather,
                        R.string.schindler_s_list
                    )
                ),

                QuestionItem(
                    R.string.question45,
                    listOf(
                        R.string.peter_jackson,
                        R.string.steven_spielberg,
                        R.string.james_cameron,
                        R.string.christopher_nolan
                    )
                ),

                QuestionItem(
                    R.string.question46,
                    listOf(
                        R.string.jennifer_lawrence,
                        R.string.emma_stone,
                        R.string.scarlett_johansson,
                        R.string.natalie_portman
                    )
                ),

                QuestionItem(
                    R.string.question47,
                    listOf(
                        R.string.the_lion_king,
                        R.string.frozen,
                        R.string.toy_story_4,
                        R.string.shrek_2
                    )
                ),

                QuestionItem(
                    R.string.question48,
                    listOf(
                        R.string.daniel_craig,
                        R.string.pierce_brosnan,
                        R.string.sean_connery,
                        R.string.roger_moore
                    )
                ),

                QuestionItem(
                    R.string.question49,
                    listOf(
                        R.string.hogwarts_school_of_witchcraft_and_wizardry,
                        R.string.beauxbatons_academy_of_magic,
                        R.string.durmstrang_institute,
                        R.string.ilvermorny_school_of_witchcraft_and_wizardry
                    )
                ),

                QuestionItem(
                    R.string.question50,
                    listOf(
                        R.string.tom_hanks,
                        R.string.tim_allen,
                        R.string.billy_crystal,
                        R.string.john_goodman
                    )
                ),

                QuestionItem(
                    R.string.question51,
                    listOf(
                        R.string.parasite,
                        R.string._1917,
                        R.string.joker,
                        R.string.the_irishman
                    )
                ),

                QuestionItem(
                    R.string.question52,
                    listOf(
                        R.string.christopher_nolan,
                        R.string.james_cameron,
                        R.string.steven_spielberg,
                        R.string.ridley_scott
                    )
                ),

                QuestionItem(
                    R.string.question53,
                    listOf(
                        R.string.the_lion_king,
                        R.string.aladdin,
                        R.string.beauty_and_the_beast,
                        R.string.mulan
                    )
                ),

                QuestionItem(
                    R.string.question54,
                    listOf(
                        R.string.quentin_tarantino,
                        R.string.martin_scorsese,
                        R.string.david_fincher,
                        R.string.stanley_kubrick
                    )
                ),

                QuestionItem(
                    R.string.question55,
                    listOf(
                        R.string.the_shawshank_redemption,
                        R.string.misery,
                        R.string.carrie,

                        R.string.cujo
                    )
                ),

                QuestionItem(
                    R.string.question56,
                    listOf(
                        R.string.robert_downey_jr,
                        R.string.chris_evans,
                        R.string.chris_hemsworth,
                        R.string.mark_ruffalo
                    )
                ),

                QuestionItem(
                    R.string.question57,
                    listOf(
                        R.string.joker,
                        R.string.parasite,
                        R.string.once_upon_a_time_in_hollywood,
                        R.string._1917
                    )
                ),

                QuestionItem(
                    R.string.question58,
                    listOf(
                        R.string.jennifer_lawrence,
                        R.string.emma_watson,
                        R.string.scarlett_johansson,
                        R.string.natalie_portman
                    )
                ),

                QuestionItem(
                    R.string.question59,
                    listOf(
                        R.string.the_matrix,
                        R.string.blade_runner,
                        R.string.inception,
                        R.string.the_terminator
                    )
                ),

                QuestionItem(
                    R.string.question60,
                    listOf(
                        R.string.finding_nemo,
                        R.string.shark_tale,
                        R.string.the_little_mermaid,
                        R.string.madagascar
                    )
                )
            )
        )
}

data class QuestionItem(
    val questionIndex: Int,
    val listOfAnswers: List<Int>
)