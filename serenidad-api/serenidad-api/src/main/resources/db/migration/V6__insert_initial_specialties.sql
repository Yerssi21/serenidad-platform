-- =========================================================
-- 1. DEPENDENCIA EMOCIONAL
-- =========================================================

WITH specialty AS (
    INSERT INTO specialties (
        title,
        slug,
        summary,
        image,
        display_order,
        active
    )
    VALUES (
        'Dependencia emocional',
        'dependencia-emocional',
        $$La dependencia emocional puede aparecer cuando la necesidad de afecto, aprobación, compañía o seguridad de otra persona empieza a ocupar demasiado espacio en tu vida.$$,
        NULL,
        1,
        TRUE
    )
    RETURNING id
)

INSERT INTO specialty_sections (
    specialty_id,
    title,
    content,
    display_order
)

SELECT
    id,
    NULL,
    $$La dependencia emocional puede aparecer cuando la necesidad de afecto, aprobación, compañía o seguridad de otra persona empieza a ocupar demasiado espacio en tu vida. En esos momentos, puede ser difícil tomar decisiones por ti misma, atender tus propias necesidades o sentirte bien cuando estás sola.

Esta condición se relaciona con una necesidad intensa de cuidado, dificultades para tomar decisiones de forma autónoma y un miedo importante a la separación o al abandono. Esto no significa que todas las personas que viven dependencia emocional tengan un trastorno de personalidad.$$,
    1
FROM specialty

UNION ALL

SELECT
    id,
    'Mi forma de acompañarte',
    $$Trabajo desde un enfoque integrador y utilizo, entre otros recursos, la Terapia de Aceptación y Compromiso (ACT). Este enfoque nos ayuda a comprender mejor tus pensamientos, emociones y formas de actuar, a tratarte con más amabilidad y flexibilidad, y a conectar con lo que realmente es importante para ti.

No creo en una terapia en la que se imponen decisiones. Mi papel no es decirte si debes continuar o terminar una relación, qué tienes que hacer o cómo tienes que vivir. La terapia no consiste en darte instrucciones que debas cumplir, sino en acompañarte y proponerte posibles cambios para que puedas valorar qué te resulta útil y decidir libremente qué quieres incorporar a tu proceso.

Estoy aquí para escucharte, acompañarte y ofrecerte herramientas, respetando siempre tu ritmo, tus circunstancias y tus decisiones. Cada persona y cada historia son diferentes, por eso adapto el proceso a tus necesidades, valores y objetivos. Podemos explorar nuevas formas de entender lo que ocurre, revisar pensamientos que te generan malestar y probar cambios en tus conductas o en tu manera de relacionarte, siempre como propuestas y no como obligaciones.

Durante la terapia podemos trabajar para comprender mejor lo que ocurre en tus relaciones, reconocer tus necesidades y emociones, fortalecer tu autoestima y ayudarte a poner la atención en lo que tú necesitas y deseas, sin que tu bienestar dependa constantemente de la aprobación de la otra persona. También podemos aprender a poner límites saludables, recuperar poco a poco tu autonomía e identificar patrones de pensamiento y comportamiento que mantienen el malestar, explorando alternativas más flexibles, respetuosas y coherentes contigo.

Para mí, la libertad individual no significa necesariamente estar sola ni dejar una relación. Significa poder comprenderte, escucharte y tomar tus propias decisiones con mayor claridad y libertad, en lugar de hacerlo únicamente desde el miedo, la necesidad o el temor a perder a la otra persona.

Mi objetivo es acompañarte a construir una relación más sana contigo misma y con los demás, en la que puedas querer y vincularte sin dejar de ser tú, ofreciéndote sugerencias y herramientas que puedas valorar y adaptar a tu propia realidad.$$,
    2
FROM specialty;


-- =========================================================
-- 2. ADICCIONES COMPORTAMENTALES
-- =========================================================

WITH specialty AS (
    INSERT INTO specialties (
        title,
        slug,
        summary,
        image,
        display_order,
        active
    )
    VALUES (
        'Adicciones comportamentales',
        'adicciones-comportamentales',
        $$Las adicciones comportamentales son patrones de conducta que pueden llegar a ocupar un lugar central en la vida de una persona, generando una necesidad difícil de controlar.$$,
        NULL,
        2,
        TRUE
    )
    RETURNING id
)

INSERT INTO specialty_sections (
    specialty_id,
    title,
    content,
    display_order
)

SELECT
    id,
    NULL,
    $$Las adicciones comportamentales son patrones de conducta que pueden llegar a ocupar un lugar central en la vida de una persona, generando una necesidad difícil de controlar, una preocupación persistente y una pérdida progresiva de libertad frente a esa conducta.

Existen conductas que pueden adquirir características problemáticas o adictivas —como el uso de internet, videojuegos, compras o determinadas conductas relacionadas con las nuevas tecnologías—, aunque no todas están reconocidas como diagnósticos independientes en el DSM-5-TR. Por ello, es importante valorar cada caso de manera individual y comprender qué función está cumpliendo esa conducta en la vida de la persona.$$,
    1
FROM specialty

UNION ALL

SELECT
    id,
    'Mi forma de acompañarte',
    $$Trabajo desde las terapias de tercera generación, especialmente desde la Terapia de Aceptación y Compromiso (ACT). Este enfoque nos permite trabajar sobre la relación que tienes con tus pensamientos, emociones y deseos, desarrollando una mayor flexibilidad psicológica y aprendiendo a actuar de acuerdo con aquello que realmente valoras.

Mi objetivo no es simplemente que dejes de realizar una conducta, sino ayudarte a comprender qué está ocurriendo, qué necesidades está intentando cubrir esa conducta y qué factores están manteniendo el ciclo de la adicción.

Cuando la obsesión, el impulso o la necesidad de realizar una conducta comienzan a ocupar demasiado espacio, podemos trabajar para que recuperes progresivamente tu capacidad de elegir y para que esa conducta deje de dirigir tu vida.$$,
    2
FROM specialty

UNION ALL

SELECT
    id,
    'Un proceso individualizado y sin imposiciones',
    $$No creo en una terapia basada en la obligación. Mi papel no es imponerte lo que tienes que hacer, sino sugerir, acompañar y ofrecerte herramientas para que puedas tomar tus propias decisiones.

Cada persona tiene una historia, unas circunstancias, unos valores y unas necesidades diferentes. Por eso, individualizo cada proceso terapéutico, adaptando las estrategias y objetivos a tu situación particular y respetando siempre tu ritmo.

Te acompañaré a comprenderte mejor, identificar los pensamientos y emociones relacionados con la conducta, aprender a relacionarte de una manera diferente con los impulsos y desarrollar alternativas que te permitan recuperar espacios de libertad en tu vida.

Porque para mí, recuperarse no consiste únicamente en dejar de hacer algo. Consiste en recuperar la libertad de elegir cómo quieres vivir, comprenderte profundamente y construir una vida que tenga sentido para ti, en la que tus decisiones estén guiadas por tus valores y no por la obsesión, el impulso o la necesidad de realizar una determinada conducta.

Tú decides el camino. Mi función es acompañarte, sugerirte y ofrecerte herramientas para que puedas recorrerlo con mayor comprensión, libertad y autonomía.$$,
    3
FROM specialty;


-- =========================================================
-- 3. TRASTORNO DEPRESIVO
-- =========================================================

WITH specialty AS (
    INSERT INTO specialties (
        title,
        slug,
        summary,
        image,
        display_order,
        active
    )
    VALUES (
        'Trastorno depresivo',
        'trastorno-depresivo',
        $$La depresión es mucho más que estar triste o atravesar unos días difíciles. Puede afectar profundamente a la forma en que una persona piensa, siente y se relaciona consigo misma y con su entorno.$$,
        NULL,
        3,
        TRUE
    )
    RETURNING id
)

INSERT INTO specialty_sections (
    specialty_id,
    title,
    content,
    display_order
)

SELECT
    id,
    NULL,
    $$La depresión es mucho más que estar triste o atravesar unos días difíciles. Es un trastorno que puede afectar profundamente a la forma en que una persona piensa, siente y se relaciona consigo misma y con su entorno, llegando a interferir en su vida cotidiana, sus relaciones, sus responsabilidades y su capacidad para disfrutar.

Según el DSM-5-TR, los trastornos depresivos comprenden diferentes cuadros clínicos. Entre ellos se encuentra el trastorno depresivo mayor, que puede caracterizarse por síntomas como un estado de ánimo deprimido, pérdida de interés o placer, cambios en el sueño o el apetito, cansancio, dificultades de concentración, sentimientos de culpa o inutilidad y, en algunos casos, pensamientos relacionados con la muerte. La intensidad, duración y combinación de estos síntomas varían de una persona a otra, por lo que es fundamental realizar una valoración individualizada.

La depresión no define quién eres. Es una experiencia que puede comprenderse, tratarse y acompañarse.$$,
    1
FROM specialty

UNION ALL

SELECT
    id,
    'Mi forma de acompañarte',
    $$Trabajo desde las terapias de tercera generación, especialmente desde la Terapia de Aceptación y Compromiso (ACT). Este enfoque nos ayuda a comprender la relación que tienes con tus pensamientos y emociones, desarrollar una mayor flexibilidad psicológica y recuperar progresivamente la conexión con aquello que realmente es importante para ti.

Mi objetivo no es obligarte a cambiar ni decirte cómo tienes que vivir. Acompaño desde la sugerencia, nunca desde la obligación. Te ofrezco herramientas, propuestas y diferentes caminos para que puedas descubrir cuáles se adaptan mejor a ti y decidir libremente qué quieres incorporar a tu proceso.

Cada persona vive la depresión de una manera diferente. Por eso, individualizo cada proceso terapéutico, teniendo en cuenta tu historia, tus circunstancias, tus necesidades, tus valores y tus objetivos.

Durante la terapia podemos trabajar para comprender qué está manteniendo tu malestar, identificar pensamientos y patrones que pueden estar alimentando la depresión, recuperar poco a poco actividades significativas, fortalecer tus recursos personales y volver a conectar con aquello que te aporta sentido y bienestar.

No se trata simplemente de obligarte a “pensar en positivo” o de decirte que tienes que estar bien. Se trata de comprenderte, aceptar lo que estás viviendo trabajando el pensamiento y comenzar a construir, paso a paso, una vida que vuelva a tener sentido para ti.

Mi objetivo es acompañarte a recuperar tu autonomía, tu capacidad de elegir y aquellos espacios de tu vida en los que puedas volver a experimentar bienestar, ilusión y satisfacción.

No tienes que recorrer este camino solo. Mi función es acompañarte, sugerirte y ofrecerte herramientas para que puedas recuperar progresivamente tu libertad, comprenderte mejor y volver a construir una vida en la que puedas sentirte tú mismo.$$,
    2
FROM specialty;


-- =========================================================
-- 4. ANSIEDAD
-- =========================================================

WITH specialty AS (
    INSERT INTO specialties (
        title,
        slug,
        summary,
        image,
        display_order,
        active
    )
    VALUES (
        'Ansiedad',
        'ansiedad',
        $$La ansiedad es una respuesta natural de tu cuerpo cuando percibes una situación como amenazante, incierta o difícil de afrontar.$$,
        NULL,
        4,
        TRUE
    )
    RETURNING id
)

INSERT INTO specialty_sections (
    specialty_id,
    title,
    content,
    display_order
)

SELECT
    id,
    NULL,
    $$La ansiedad es una respuesta natural de tu cuerpo cuando percibes una situación como amenazante, incierta o difícil de afrontar. Puede ayudarte a prepararte y protegerte. Sin embargo, cuando es muy intensa, dura mucho tiempo o resulta difícil de controlar, puede empezar a afectar a tu día a día y limitar tu libertad.

Según el DSM-5-TR, existen distintos trastornos de ansiedad, como el trastorno de ansiedad generalizada, el trastorno de pánico, las fobias específicas, el trastorno de ansiedad social y la agorafobia, entre otros. Cada uno tiene sus propias características, por lo que es importante valorar tu situación de forma individual.

A menudo, la ansiedad está relacionada con el miedo, la preocupación, la anticipación de lo que podría pasar o la sensación de estar en peligro, aunque en ese momento no exista una amenaza real. Tu mente puede intentar adelantarse continuamente al futuro para protegerte. Esto puede generar pensamientos repetitivos, tensión, inquietud y sensación de falta de control.

La ansiedad puede aparecer tanto en tu mente como en tu cuerpo. Puedes notar preocupación constante, pensamientos difíciles de detener, irritabilidad, problemas para concentrarte, tensión muscular, dificultades para dormir, palpitaciones o sensación de falta de aire, entre otros síntomas.$$,
    1
FROM specialty

UNION ALL

SELECT
    id,
    'Mi forma de acompañarte',
    $$Trabajo desde las terapias de tercera generación, especialmente desde la Terapia de Aceptación y Compromiso (ACT). Te ayudo a comprender mejor cómo te relacionas con tus pensamientos, tus emociones y las sensaciones físicas que aparecen cuando sientes ansiedad.

También utilizo herramientas como la respiración consciente, la meditación y la atención plena, siempre adaptándolas a tus necesidades y a tu momento vital.

Para mí, acompañarte significa ofrecerte orientación y propuestas, no decirte lo que tienes que hacer. Te proporcionaré distintas herramientas para que puedas probarlas, descubrir cuáles te ayudan y decidir qué quieres incorporar a tu proceso.

Cada persona vive la ansiedad de una manera diferente. Por eso, adapto cada proceso terapéutico a ti, teniendo en cuenta tu historia, tus circunstancias, tus necesidades, tus valores y tus objetivos.

Juntos podremos comprender mejor qué hay detrás de tu ansiedad, reconocer los pensamientos y hábitos que pueden estar manteniéndola y aprender a relacionarte de otra manera con lo que ocurre dentro de ti.

El objetivo no es luchar todo el tiempo contra tus pensamientos ni controlar cada sensación. Se trata de aprender a comprender tu mente, relacionarte con ella de una forma más flexible y recuperar la capacidad de elegir cómo quieres vivir.

Mi propósito es ayudarte a reducir el malestar relacionado con la ansiedad y a recuperar poco a poco tu autonomía. Así podrás volver a disfrutar de una vida plena, significativa y con mayor libertad, sin sentirte constantemente limitada por tus miedos, tus preocupaciones o tus pensamientos.

La ansiedad puede ocupar mucho espacio en tu vida, pero no tiene por qué dirigirla. Mi función es acompañarte, ofrecerte propuestas y compartir contigo herramientas para que puedas comprenderte mejor, recuperar tu libertad y vivir de acuerdo con lo que realmente es importante para ti.$$,
    2
FROM specialty;


-- =========================================================
-- 5. BAJA AUTOESTIMA
-- =========================================================

WITH specialty AS (
    INSERT INTO specialties (
        title,
        slug,
        summary,
        image,
        display_order,
        active
    )
    VALUES (
        'Baja autoestima',
        'baja-autoestima',
        $$La autoestima es la forma en la que te percibes, te valoras y te relacionas contigo misma.$$,
        NULL,
        5,
        TRUE
    )
    RETURNING id
)

INSERT INTO specialty_sections (
    specialty_id,
    title,
    content,
    display_order
)

SELECT
    id,
    NULL,
    $$La autoestima es la forma en la que te percibes, te valoras y te relacionas contigo misma. No significa pensar que eres perfecta ni sentirte bien todo el tiempo, sino poder reconocerte como una persona valiosa, aceptar tus fortalezas y dificultades y tratarte con respeto incluso cuando las cosas no salen como esperabas.

Cuando existe una baja autoestima, es frecuente que aparezcan pensamientos de desvalorización, comparación constante, inseguridad, necesidad de aprobación, miedo a equivocarse o una tendencia a ser excesivamente crítica contigo misma. Los autojuicios pueden convertirse en una voz interna muy exigente que termina condicionando tus decisiones, tus relaciones y la manera en la que disfrutas de la vida.

A veces podemos llegar a creer que necesitamos cambiar quiénes somos para sentirnos suficientes. Sin embargo, trabajar la autoestima también implica aprender a aceptarte, comprenderte y relacionarte contigo desde un lugar más amable y flexible.$$,
    1
FROM specialty

UNION ALL

SELECT
    id,
    'Mi forma de acompañarte',
    $$Trabajo desde las terapias de tercera generación, especialmente desde la Terapia de Aceptación y Compromiso (ACT). Desde este enfoque podemos trabajar la relación que mantienes con tus pensamientos y autojuicios, aprendiendo a observarlos sin que tengan que determinar cómo te sientes, qué decisiones tomas o cuánto valor te das.

Mi manera de acompañarte parte de algo fundamental: sugerencia, nunca obligación. No quiero decirte cómo tienes que sentirte, qué tienes que cambiar o cómo deberías ser. Te ofrezco propuestas, herramientas y diferentes posibilidades para que puedas descubrir qué te ayuda y decidir libremente qué quieres incorporar a tu proceso.

Cada persona tiene una historia diferente. Por eso, individualizo cada proceso terapéutico, teniendo en cuenta tus experiencias, tus circunstancias, tus necesidades, tus valores y aquello que quieres conseguir.

Durante el proceso podemos trabajar para identificar los pensamientos y creencias que alimentan la inseguridad, comprender de dónde proceden tus autoexigencias, aprender a relacionarte de una manera diferente con la crítica interna y desarrollar una mirada hacia ti misma basada en el respeto y la comprensión.

El objetivo no es obligarte a pensar que todo en ti es maravilloso. Es ayudarte a construir una relación contigo en la que no necesites ser perfecta para sentir que eres suficiente.

Quiero acompañarte a recuperar la confianza en ti misma, reconocer tus necesidades, poner límites saludables y tomar decisiones desde tus propios valores, en lugar de hacerlo únicamente desde el miedo, la comparación o la necesidad de aprobación.

Porque recuperar la autoestima no significa convertirte en otra persona. Significa volver a encontrarte, comprenderte y aprender a quererte sin tener que luchar constantemente contra quien eres.

Mi propósito es acompañarte a liberarte progresivamente de los autojuicios y de aquellas ataduras mentales que te impiden disfrutar de ti misma, para que puedas construir una vida más plena, auténtica y libre.

No tienes que convertirte en alguien diferente para aprender a quererte. Mi función es acompañarte, sugerirte y ofrecerte herramientas para que puedas volver a reconocerte, valorarte y vivir desde el respeto hacia ti misma.$$,
    2
FROM specialty;