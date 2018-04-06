//
//  LocationTVC.swift
//  Feasta
//
//  Created by amota511 on 4/5/18.
//  Copyright © 2018 Aaron Motayne. All rights reserved.
//

import UIKit

class LocationTVC: UITableViewController {

    let imgArray: [UIImage] = [#imageLiteral(resourceName: "dac_1_560x340"), #imageLiteral(resourceName: "SJH"), #imageLiteral(resourceName: "Library")]
    let titleArray: [String] = ["DAC", "SJH", "LIB"]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        self.tableView.register(LocationCell.self, forCellReuseIdentifier: "locationCell")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 3
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "locationCell", for: indexPath) as! LocationCell

        cell.imgView.center = cell.center
        cell.imgView.frame = cell.bounds
        
        cell.imgView.image = imgArray[indexPath.row]
        cell.imgView.contentMode = .scaleAspectFill
        cell.imgView.clipsToBounds = true
        
        
        cell.txtLabel.frame = CGRect(origin: CGPoint(x: 0, y: 0), size: CGSize(width: cell.frame.width * 0.75, height: cell.frame.height * 0.45))
        
        //cell.txtLabel.backgroundColor = .green
        
        cell.txtLabel.center.x = cell.center.x
        cell.txtLabel.center.y = cell.frame.height * 0.5
        
        cell.txtLabel.text = titleArray[indexPath.row]
        cell.txtLabel.textAlignment = .center
        cell.txtLabel.textColor = .white
        cell.txtLabel.font = cell.txtLabel.font.withSize(75)
        
        
        cell.addSubview(cell.imgView)
        cell.addSubview(cell.txtLabel)

        return cell
    }
 

    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return self.view.frame.height * 0.2
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let eventsTVC = EventsTVC()
        self.navigationController?.pushViewController(eventsTVC, animated: true)
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
