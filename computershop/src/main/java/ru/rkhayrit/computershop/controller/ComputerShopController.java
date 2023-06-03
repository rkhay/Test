package ru.rkhayrit.computershop.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rkhayrit.computershop.exception.RecordNotFoundException;
import ru.rkhayrit.computershop.model.DesktopComputer;
import ru.rkhayrit.computershop.model.HardDisk;
import ru.rkhayrit.computershop.model.Monitor;
import ru.rkhayrit.computershop.model.NoteBook;
import ru.rkhayrit.computershop.service.DesktopComputerService;
import ru.rkhayrit.computershop.service.HardDiskService;
import ru.rkhayrit.computershop.service.MonitorService;
import ru.rkhayrit.computershop.service.NoteBookService;

import java.util.List;

@RestController
@RequestMapping("/computerShop")
public class ComputerShopController {

    @Autowired
    private DesktopComputerService desktopComputerService;
    @Autowired
    private NoteBookService noteBookService;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private HardDiskService hardDiskService;


    // Desktop Computers
    @GetMapping("/computer")
    public ResponseEntity<List<DesktopComputer>> getAllDesktops() {
        List<DesktopComputer> list = desktopComputerService.getAllDesktopComputers();
        return new ResponseEntity<List<DesktopComputer>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/computer/{id}")
    public ResponseEntity<DesktopComputer> getDesktopComputerById(@PathVariable("id") Long id) {
        DesktopComputer entity = desktopComputerService.getComputerById(id);
        return new ResponseEntity<DesktopComputer>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/computer")
    public ResponseEntity<DesktopComputer> addDesktopComputer(@RequestBody @Valid DesktopComputer desktopComputer) {
        DesktopComputer updated = desktopComputerService.addComputer(desktopComputer);
        return new ResponseEntity<DesktopComputer>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/computer")
    public ResponseEntity<DesktopComputer> updateDesktopComputer(@RequestBody @Valid DesktopComputer desktopComputer) {
        DesktopComputer  updated = desktopComputerService.updateComputer(desktopComputer);
        return new ResponseEntity<DesktopComputer>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/computer/{id}")
    public HttpStatus deleteComputerById(@PathVariable("id") Long id)
    {
        desktopComputerService.deleteDesktopComputerById(id);
        return HttpStatus.OK;
    }


    // Hard disks

    @GetMapping("/harddisk")
    public ResponseEntity<List<HardDisk>> getAllHardDisk() {
        List<HardDisk> list = hardDiskService.getAllHardDisks();
        return new ResponseEntity<List<HardDisk>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/harddisk/{id}")
    public ResponseEntity<HardDisk> getHardDiskById(@PathVariable("id") Long id) {
        HardDisk entity = hardDiskService.getHardDiskById(id);
        return new ResponseEntity<HardDisk>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/harddisk")
    public ResponseEntity<HardDisk> addHardDisk(@RequestBody @Valid HardDisk hardDisk) {
        HardDisk updated = hardDiskService.addHardDisk(hardDisk);
        return new ResponseEntity<HardDisk>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/harddisk")
    public ResponseEntity<HardDisk> updateHardDisk(@RequestBody @Valid HardDisk hardDisk) {
        HardDisk updated = hardDiskService.updateHardDisk(hardDisk);
        return new ResponseEntity<HardDisk>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/harddisk/{id}")
    public HttpStatus deleteHardDiskById(@PathVariable("id") Long id)
    {
        hardDiskService.deleteHardDiskById(id);
        return HttpStatus.OK;
    }

    // Monitors

    @GetMapping("/monitor")
    public ResponseEntity<List<Monitor>> getAllMonitors() {
        List<Monitor> list = monitorService.getAllMonitors();
        return new ResponseEntity<List<Monitor>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/monitor/{id}")
    public ResponseEntity<Monitor> getMonitorById(@PathVariable("id") Long id) {
        Monitor entity = monitorService.getMonitorById(id);
        return new ResponseEntity<Monitor>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/monitor")
    public ResponseEntity<Monitor> addMonitor(@RequestBody @Valid Monitor monitor) {
        Monitor updated = monitorService.addMonitor(monitor);
        return new ResponseEntity<Monitor>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/monitor")
    public ResponseEntity<Monitor> updateDesktopComputer(@RequestBody @Valid Monitor monitor) {
        Monitor updated = monitorService.updateMonitor(monitor);
        return new ResponseEntity<Monitor>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/monitor/{id}")
    public HttpStatus deleteMonitorById(@PathVariable("id") Long id)
    {
        monitorService.deleteMonitorById(id);
        return HttpStatus.OK;
    }

    //NoteBooks

    @GetMapping("/notebook")
    public ResponseEntity<List<NoteBook>> getAllNoteBooks() {
        List<NoteBook> list = noteBookService.getAllNoteBooks();
        return new ResponseEntity<List<NoteBook>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/notebook/{id}")
    public ResponseEntity<NoteBook> getNotebookById(@PathVariable("id") Long id) {
        NoteBook entity = noteBookService.getNoteBookById(id);
        return new ResponseEntity<NoteBook>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/notebook")
    public ResponseEntity<NoteBook> addDesktopComputer(@RequestBody @Valid NoteBook noteBook) {
        NoteBook updated = noteBookService.addNoteBook(noteBook);
        return new ResponseEntity<NoteBook>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/notebook")
    public ResponseEntity<NoteBook> updateNoteBook(@RequestBody @Valid NoteBook noteBook) {
        NoteBook  updated = noteBookService.updateNoteBook(noteBook);
        return new ResponseEntity<NoteBook>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/notebook/{id}")
    public HttpStatus deleteNoteBookById(@PathVariable("id") Long id)
    {
        noteBookService.deleteNoteBookById(id);
        return HttpStatus.OK;
    }



}
