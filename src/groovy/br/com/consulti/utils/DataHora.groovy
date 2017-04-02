package br.com.consulti.utils

/**
 *
 */
class DataHora {
    //
    static final String DATA_FORMAT = 'd/M/yyyy'

    /**
     *
     * @param data
     * @return
     */
    static Date getDateByString(String data) {
        return getDateByString (DATA_FORMAT, data)
    }

    static Date getDateByString(String format, String data) {
        Date date = null

        if (data && format) {
            date = Date.parse(format, data)
        }

        return date
    }
}
