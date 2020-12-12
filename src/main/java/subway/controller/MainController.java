package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import util.validator.Validation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static final List<String> preregisterStations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<String> preregisterLines = Arrays.asList("2호선", "3호선", "신분당선");
    private static final String STATION_CONTROL = "1";
    private static final String LINE_CONTROL = "2";
    private static final String LINE_SECTION_CONTROL = "3";
    private static final String MAP_PRINT_CONTROL = "4";
    private static final String QUIT = "Q";

    public void start(Scanner scanner) {
        registerInitialSetup();
        chooseController(scanner);
    }

    private void registerInitialSetup() {
        for (String station : preregisterStations) {
            StationRepository.addStation(new Station(station));
        }
        for (String line : preregisterLines) {
            LineRepository.addLine(new Line(line));
        }
    }

    private void chooseController(Scanner scanner) {
        String userChoice = "";
        while (!userChoice.equals(QUIT)) {
            OutputView.printMainControllerOption();
            userChoice = getUserMainControllerChoice(scanner);
            if (userChoice.equals(STATION_CONTROL)) {
                StationController.start(scanner);
            } else if (userChoice.equals(LINE_CONTROL)) {
                LineController.start(scanner);
            } else if (userChoice.equals(LINE_SECTION_CONTROL)) {
                LineSectionController.start(scanner);
            } else if (userChoice.equals(MAP_PRINT_CONTROL)) {
                MapPrintController.start(scanner);
            }
        }
    }

    private String getUserMainControllerChoice(Scanner scanner) {
        String userChoice = null;
        boolean properChoice = false;
        while (!properChoice) {
            OutputView.printOptionInstruction();
            userChoice = InputView.getInput(scanner);
            properChoice = Validation.checkMainControllerInput(userChoice);
            OutputView.printNewLine();
        }
        return userChoice;
    }
}
