package view;

import model.Gasket;

public class ConsoleHelper {
    public static void writeMessage(String string) {
        Gasket.getViewThreadClass().updateInfoView(string);
//        WriterAndReadFile.writerFile(string + "\n"
//                , Gasket.getFilesAndPathCreator().getPathLogs()
//                , true);
        System.out.println(string);
    }


    public static String getStringInfoSettings() {
        return  Gasket.getSettingNow()
                + "\n"
                + "\n"
//                + "whetherOrNotShowLearningProcess === " + Gasket.isWhetherOrNotShowLearningProcess()
//                + " ----- выводить или нет выводить на экран процесс обучения НН\n"
//                + "numberOfTrainingCycles === " + Gasket.getNumberOfTrainingCycles()
//                + " ----- количество циклов обучения НН\n"
//                + "numberOfOutputNeurons === " + Gasket.getNumberOfOutputNeurons()
//                + " ----- количество выходных нейронов НН\n"
//                + "numberOfInputNeurons === " + Gasket.getNumberOfInputNeurons()
//                + " ----- количество входных нейронов\n"
//                + "priceChangeToFormHistoryPattern === " + Gasket.getPriceChangeToFormHistoryPattern()
//                + " ----- изменение цены для формирования паттерна истории\n"
//                + "numberOfIndicatorsForOneCandle === " + Gasket.getNumberOfIndicatorsForOneCandle()
//                + " ----- количество показателей по одной свече\n"
//                + "numberOfCandlesToDetectMovement === " + Gasket.getNumberOfCandlesToDetectMovement()
//                + " ----- количество свечек для определения движения buy, sell, flat\n"
//                + "turnOnTurnOffLearning === " + Gasket.isTurnOnTurnOffLearning()
//                + " ----- включить выключить процесс обучения\n"
//                + "learningRate === " + Gasket.getLearningRate()
//                + " ----- шаг обучения\n"
//                + "minDigitWeightForSell === " + Gasket.getMinDigitWeightForSell()
//                + " ----- минимальный порог для принятия решения по Селл\n"
//                + "minDigitWeightForBuy === " + Gasket.getMinDigitWeightForBuy()
//                + " ----- минимальный порог для принятия решения по Бай\n"
//                + "predictNextCandle === " + Gasket.isPredictNextCandle()
//                + " ----- предсказать следующую свечку\n"
                + "\n"
                + "\n"
                + "dateDifference === " + Gasket.getDateDifference()
                + " ----- на сколько время в терминале отстает или опережает местное\n"
                + "\n";
    }
}
